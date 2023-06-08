package ma.sir.pmp.zynerator.controller;

import ma.sir.pmp.zynerator.audit.AuditBusinessObject;
import ma.sir.pmp.zynerator.converter.AbstractConverter;
import ma.sir.pmp.zynerator.criteria.BaseCriteria;
import ma.sir.pmp.zynerator.dto.AuditEntityDto;
import ma.sir.pmp.zynerator.dto.BaseDto;
import ma.sir.pmp.zynerator.exception.GlobalException;
import ma.sir.pmp.zynerator.export.ExportModel;
import ma.sir.pmp.zynerator.history.HistBusinessObject;
import ma.sir.pmp.zynerator.service.IService;
import ma.sir.pmp.zynerator.util.*;
import ma.sir.pmp.zynerator.dto.FileTempDto;
import ma.sir.pmp.zynerator.exception.BusinessRuleException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;


public class AbstractController<T extends AuditBusinessObject, DTO extends BaseDto, H extends HistBusinessObject, Criteria extends BaseCriteria, HistoryCriteria extends BaseCriteria, SERV extends IService<T, Criteria, HistoryCriteria>, CONV extends AbstractConverter<T, DTO, H>> {
    protected SERV service;
    protected AbstractConverter<T, DTO, H> converter;
    @Autowired
    private MessageSource messageSource;


@Value("${uploads.location.directory}")
    private String UPLOADED_FOLDER;
 @Value("${uploads.location.temp}")
    private String UPLOADED_TEMP_FOLDER;


    public String generateRandomFileName(String fileName) throws IOException {
        String extention = com.google.common.io.Files.getFileExtension(fileName);
        String prefix = "tmp";
        if (StringUtil.isNotEmpty(extention)) {
        File tmpQuittanceFile = File.createTempFile(prefix, "."+extention, new File(UPLOADED_TEMP_FOLDER));
            return tmpQuittanceFile.getName();
        }
        return String.valueOf(UniqueID.get());
    }

    public static String removeExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? fileName : fileName.substring(0, dotIndex);
    }


    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        List<FileTempDto> result= new ArrayList<>();
        if (files != null) {
            for (MultipartFile file : files) {
                result.add(uploadFileAndGetChecksum(file).getBody());
            }
        }
        return new ResponseEntity<List<FileTempDto>>(result, HttpStatus.OK);
    }

    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        FileTempDto object = new FileTempDto();
        String checksum = "";
        if (file != null) {
            File convFile = new File(UPLOADED_FOLDER + generateRandomFileName(file.getOriginalFilename()));
            if (!convFile.getParentFile().exists())
            convFile.getParentFile().mkdirs();
            convFile.createNewFile();
            FileOutputStream fos = new FileOutputStream(convFile);
            fos.write(file.getBytes());
            fos.close();
            checksum = MD5Checksum.getMD5Checksum(convFile.getPath());
            object.setId(removeExtension(convFile.getName()));
            object.setChecksumValue(checksum);
            object.setOriginalFileName(file.getOriginalFilename());
            object.setFileName(convFile.getName());
            return new ResponseEntity<FileTempDto>(object, HttpStatus.OK);
        }
        return new ResponseEntity<FileTempDto>(HttpStatus.NOT_FOUND);
    }

    // Download file
    public static ResponseEntity<InputStreamResource> getExportedFileResource(ExportModel exportModel, String uploadFolder) throws Exception {
        if (exportModel != null && exportModel.getList() != null && !exportModel.getList().isEmpty()) {
            String fichier = ExportUtil.exportedList(exportModel, uploadFolder);
            File file = new File(fichier);
            FileInputStream inputStream = new FileInputStream(file);
            InputStreamResource inputStreamResource = new InputStreamResource(inputStream);
            String fileName = FileUtils.getFileName(file.getName());
            return ResponseEntity.ok().eTag(fileName).contentLength(file.length()).contentType(MediaType.parseMediaType(Files.probeContentType(file.toPath()))).body(inputStreamResource);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    protected static ClientHttpRequestFactory clientHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setReadTimeout(200000);
        factory.setConnectTimeout(200000);
        return factory;
    }

    private static boolean isNotEmpty(ExportModel exportModel) {
        return exportModel != null && exportModel.getList() != null && !exportModel.getList().isEmpty();
    }

    public ResponseEntity<DTO> findById(Long id, String[] includes, String[] excludes) throws Exception {
        T t = service.findById(id);
        converter.init(true);
        DTO dto = converter.toDto(t);
        return getDtoResponseEntity(dto, includes, excludes);
    }

    public ResponseEntity<DTO> findWithAssociatedLists(Long id) {
        T loaded =  service.findWithAssociatedLists(id);
        converter.init(true);
        DTO dto = converter.toDto(loaded);
        return new ResponseEntity<>(dto, HttpStatus.OK);
     }

    private  ResponseEntity<DTO> getDtoResponseEntity(DTO dto, String[] includes, String[] excludes) throws Exception {
        if (StringUtil.isNoEmpty(includes) || StringUtil.isNoEmpty(excludes))
            dto = converter.copyIncludeExclude(dto, includes, excludes);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }


    public ResponseEntity<DTO> save(DTO dto) throws Exception {
        if(dto!=null){
            converter.init(true);
            T myT = converter.toItem(dto);
            T t = service.create(myT);
            DTO myDto = converter.toDto(t);
            return new ResponseEntity<>(myDto, HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(dto, HttpStatus.NO_CONTENT);
        }
    }


    public ResponseEntity<DTO> update(DTO dto) throws Exception {
        ResponseEntity<DTO> res ;
        if (dto.getId() == null || service.findById(dto.getId()) == null)
            res = new ResponseEntity<>(HttpStatus.CONFLICT);
        else {
            T t = service.findById(dto.getId());
            converter.copy(dto,t);
            T updated = service.update(t);
            DTO myDto = converter.toDto(updated);
            res = new ResponseEntity<>(myDto, HttpStatus.OK);
        }
        return res;
    }


    public ResponseEntity<List<DTO>> delete(List<DTO> dtos) throws Exception {
        ResponseEntity<List<DTO>> res ;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dtos != null && !dtos.isEmpty()) {
            converter.init(false);
            List<T> ts = converter.toItem(dtos);
            service.delete(ts);
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    public ResponseEntity<DTO> delete(DTO dto) throws Exception {
        ResponseEntity<DTO> res;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dto != null) {
            converter.init(false);
            T t = converter.toItem(dto);
            service.delete(Arrays.asList(t));
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dto, status);
        return res;
    }


    protected ResponseEntity<Long> deleteById(Long id)  throws Exception {
        ResponseEntity<Long> res;
        HttpStatus status = HttpStatus.CONFLICT;
        if (id != null) {
            service.deleteById(id);
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(id, status);
        return res;
    }


    protected ResponseEntity<List<Long>> deleteByIdIn(List<Long> ids)  throws Exception {
        ResponseEntity<List<Long>> res;
        HttpStatus status = HttpStatus.CONFLICT;
        if (ids != null) {
            service.deleteByIdIn(ids);
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(ids, status);
        return res;
    }

    public ResponseEntity<List<DTO>> findByCriteria(Criteria criteria) throws Exception {
        ResponseEntity<List<DTO>> res = null;
        List<T> list = service.findByCriteria(criteria);
        List<DTO> dtos = null;
        HttpStatus status = HttpStatus.NO_CONTENT;
        if (criteria != null) {
            list = converter.copyIncludeExcludeItems(list, criteria.getIncludes(), criteria.getExcludes());
        }
        dtos = converter.toDto(list);

        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;

        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    public ResponseEntity<List<DTO>> findAll() throws Exception {
        return findByCriteria(null);
    }


    public ResponseEntity<List<DTO>> findAllOptimized() throws Exception {
        ResponseEntity<List<DTO>> res = null;
        List<T> list = service.findAllOptimized();
        List<DTO> dtos = null;
        HttpStatus status = HttpStatus.NO_CONTENT;
        dtos = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
        status = HttpStatus.OK;

        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    public ResponseEntity<PaginatedList> findPaginatedByCriteria(Criteria criteria) throws Exception {
        List<T> list = service.findPaginatedByCriteria(criteria, criteria.getPage(), criteria.getMaxResults(), criteria.getSortOrder(), criteria.getSortField());
        list = converter.copyIncludeExcludeItems(list, criteria.getIncludes(), criteria.getExcludes());
        converter.initObject(true);
        List<DTO> dtos = converter.toDto(list);
        PaginatedList paginatedList = new PaginatedList();
        paginatedList.setList(dtos);
        if (dtos != null && !dtos.isEmpty()) {
            int dateSize = service.getDataSize(criteria);
            paginatedList.setDataSize(dateSize);
        }
        return new ResponseEntity<>(paginatedList, HttpStatus.OK);
    }


    public ResponseEntity<InputStreamResource> export(Criteria criteria) throws Exception {
        ResponseEntity<InputStreamResource> res = null;
        if (criteria.getExportModel() == null)
            res = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else {
            criteria.setMaxResults(null);
            List<T> list = service.findByCriteria(criteria);
            criteria.getExportModel().setList(list);
            res = getExportedFileResource(criteria.getExportModel());
        }
        return res;
    }

    public ResponseEntity<Integer> getDataSize(Criteria criteria) throws Exception {
        int count = service.getDataSize(criteria);
        return new ResponseEntity<Integer>(count, HttpStatus.OK);

    }

    public ResponseEntity<AuditEntityDto> findHistoryById(Long id) throws Exception {
        AuditEntityDto h = service.findHistoryById(id);
        return new ResponseEntity<>(h, HttpStatus.OK);
    }

    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(HistoryCriteria criteria) throws Exception {
        List<AuditEntityDto> list = service.findHistoryPaginatedByCriteria(criteria, criteria.getPage(), criteria.getMaxResults(), criteria.getSortOrder(), criteria.getSortField());
        PaginatedList paginatedList = new PaginatedList();
        paginatedList.setList(list);
        if (list != null && !list.isEmpty()) {
            int dateSize = service.getHistoryDataSize(criteria);
            paginatedList.setDataSize(dateSize);
        }
        return new ResponseEntity<PaginatedList>(paginatedList, HttpStatus.OK);
    }

    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody HistoryCriteria criteria) throws Exception {
        if (criteria.getExportModel() == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        criteria.setMaxResults(null);
        return null;//TODO correct this bug

    }

    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody HistoryCriteria criteria) throws Exception {
        int count = service.getHistoryDataSize(criteria);
        return new ResponseEntity<Integer>(count, HttpStatus.OK);

    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception e, HttpServletRequest request) throws IOException {
        GlobalException globalException = new GlobalException(e, messageSource, request.getRequestURI());
        ErrorResponse errorResponse = new ErrorResponse(globalException.getStatus(), e, globalException.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(errorResponse, globalException.getStatus());
    }

    // Download file
    protected ResponseEntity<InputStreamResource> getExportedFileResource(ExportModel exportModel) throws Exception {
        if (isNotEmpty(exportModel)) {
            String fichier = ExportUtil.exportedList(exportModel, UPLOADED_FOLDER);
            File file = new File(fichier);
            FileInputStream inputStream = new FileInputStream(file);
            InputStreamResource inputStreamResource = new InputStreamResource(inputStream);
            String fileName = FileUtils.getFileName(file.getName());
            return ResponseEntity.ok().eTag(fileName).contentLength(file.length()).contentType(MediaType.parseMediaType(Files.probeContentType(file.toPath()))).body(inputStreamResource);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Download file
    protected ResponseEntity<InputStreamResource> getFileResource(String fichier, String fileName) throws Exception {
        if (fichier != null && !fichier.isEmpty()) {
            File file = new File(UPLOADED_FOLDER + fichier);
            if (file.exists()) {
                FileInputStream inputStream = new FileInputStream(file);
                InputStreamResource inputStreamResource = new InputStreamResource(inputStream);
                return ResponseEntity.ok().eTag(fileName).contentLength(file.length()).contentType(MediaType.parseMediaType(Files.probeContentType(file.toPath()))).body(inputStreamResource);
            }
        }
        return new ResponseEntity<InputStreamResource>(HttpStatus.NOT_FOUND);
    }


    protected ResponseEntity<List<DTO>> importData(List<DTO> dtos) {
        List<T> items = converter.toItem(dtos);
        items = service.importerData(items);
        List<DTO> result= converter.toDto(items);
        return new ResponseEntity<>(result,HttpStatus.OK);

    }


    public String uploadFile(String checksumOld, String filePath, String file) throws Exception {
        return uploadFile(checksumOld, file, filePath, false);
    }

    public String uploadFile(String checksumOld, String file, String filePath, boolean overideIfExist) throws Exception {
        String result = null;
        if (FileUtils.isFileExist(UPLOADED_TEMP_FOLDER, file) || overideIfExist) {
            if (!FileUtils.isFileExist(UPLOADED_TEMP_FOLDER, file))
                return result;
            // Vérifier checksum fichier sur le dossier temp
            String checksum = MD5Checksum.getMD5Checksum(UPLOADED_TEMP_FOLDER + file);
            if (!checksum.equals(checksumOld)) {
                throw new BusinessRuleException("errors.file.checksum", new String[]{file});
            }
            result = FileUtils.saveFile(UPLOADED_TEMP_FOLDER, UPLOADED_FOLDER, file, filePath, "");
            if (FileUtils.isFileExist(UPLOADED_FOLDER, result)) {
            // Vérifier checksum fichier sur le dossier data
            checksum = MD5Checksum.getMD5Checksum(UPLOADED_FOLDER + result);
                if (!checksum.equals(checksumOld)) {
                throw new BusinessRuleException("errors.file.checksum", new String[]{""});
                }
            } else {
                throw new BusinessRuleException("errors.file.data.creation", new String[]{""});
            }
        }
        return result;
    }
    public AbstractController(SERV service, CONV converter) {
        this.service = service;
        this.converter = converter;
    }
}
