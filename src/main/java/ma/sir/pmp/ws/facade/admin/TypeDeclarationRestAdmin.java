package  ma.sir.pmp.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.pmp.bean.core.TypeDeclaration;
import ma.sir.pmp.bean.history.TypeDeclarationHistory;
import ma.sir.pmp.dao.criteria.core.TypeDeclarationCriteria;
import ma.sir.pmp.dao.criteria.history.TypeDeclarationHistoryCriteria;
import ma.sir.pmp.service.facade.admin.TypeDeclarationAdminService;
import ma.sir.pmp.ws.converter.TypeDeclarationConverter;
import ma.sir.pmp.ws.dto.TypeDeclarationDto;
import ma.sir.pmp.zynerator.controller.AbstractController;
import ma.sir.pmp.zynerator.dto.AuditEntityDto;
import ma.sir.pmp.zynerator.util.PaginatedList;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.sir.pmp.zynerator.process.Result;


import org.springframework.web.multipart.MultipartFile;
import ma.sir.pmp.zynerator.dto.FileTempDto;

@Api("Manages typeDeclaration services")
@RestController
@RequestMapping("/api/admin/typeDeclaration/")
public class TypeDeclarationRestAdmin  extends AbstractController<TypeDeclaration, TypeDeclarationDto, TypeDeclarationHistory, TypeDeclarationCriteria, TypeDeclarationHistoryCriteria, TypeDeclarationAdminService, TypeDeclarationConverter> {


    @ApiOperation("upload one typeDeclaration")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple typeDeclarations")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all typeDeclarations")
    @GetMapping("")
    public ResponseEntity<List<TypeDeclarationDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all typeDeclarations")
    @GetMapping("optimized")
    public ResponseEntity<List<TypeDeclarationDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a typeDeclaration by id")
    @GetMapping("id/{id}")
    public ResponseEntity<TypeDeclarationDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  typeDeclaration")
    @PostMapping("")
    public ResponseEntity<TypeDeclarationDto> save(@RequestBody TypeDeclarationDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  typeDeclaration")
    @PutMapping("")
    public ResponseEntity<TypeDeclarationDto> update(@RequestBody TypeDeclarationDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of typeDeclaration")
    @PostMapping("multiple")
    public ResponseEntity<List<TypeDeclarationDto>> delete(@RequestBody List<TypeDeclarationDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified typeDeclaration")
    @DeleteMapping("")
    public ResponseEntity<TypeDeclarationDto> delete(@RequestBody TypeDeclarationDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified typeDeclaration")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple typeDeclarations by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds typeDeclarations by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<TypeDeclarationDto>> findByCriteria(@RequestBody TypeDeclarationCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated typeDeclarations by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody TypeDeclarationCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports typeDeclarations by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody TypeDeclarationCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets typeDeclaration data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody TypeDeclarationCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets typeDeclaration history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets typeDeclaration paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody TypeDeclarationHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports typeDeclaration history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody TypeDeclarationHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets typeDeclaration history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody TypeDeclarationHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public TypeDeclarationRestAdmin (TypeDeclarationAdminService service, TypeDeclarationConverter converter) {
        super(service, converter);
    }


}