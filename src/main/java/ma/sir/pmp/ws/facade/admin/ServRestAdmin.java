package  ma.sir.pmp.ws.facade.admin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.pmp.bean.core.Serv;
import ma.sir.pmp.bean.history.ServHistory;
import ma.sir.pmp.dao.criteria.core.ServCriteria;
import ma.sir.pmp.dao.criteria.history.ServHistoryCriteria;
import ma.sir.pmp.service.facade.admin.ServAdminService;
import ma.sir.pmp.ws.converter.ServConverter;
import ma.sir.pmp.ws.dto.ServDto;
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

@Api("Manages serv services")
@RestController
@RequestMapping("/api/admin/serv/")
public class ServRestAdmin  extends AbstractController<Serv, ServDto, ServHistory, ServCriteria, ServHistoryCriteria, ServAdminService, ServConverter> {


    @ApiOperation("upload one serv")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple servs")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all servs")
    @GetMapping("")
    public ResponseEntity<List<ServDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all servs")
    @GetMapping("optimized")
    public ResponseEntity<List<ServDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a serv by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ServDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  serv")
    @PostMapping("")
    public ResponseEntity<ServDto> save(@RequestBody ServDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  serv")
    @PutMapping("")
    public ResponseEntity<ServDto> update(@RequestBody ServDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of serv")
    @PostMapping("multiple")
    public ResponseEntity<List<ServDto>> delete(@RequestBody List<ServDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified serv")
    @DeleteMapping("")
    public ResponseEntity<ServDto> delete(@RequestBody ServDto dto) throws Exception {
        return super.delete(dto);
    }

    @ApiOperation("Delete the specified serv")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple servs by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
        return super.deleteByIdIn(ids);
    }


    @ApiOperation("Finds servs by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ServDto>> findByCriteria(@RequestBody ServCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated servs by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ServCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports servs by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ServCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets serv data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ServCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets serv history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets serv paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody ServHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports serv history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody ServHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets serv history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody ServHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public ServRestAdmin (ServAdminService service, ServConverter converter) {
        super(service, converter);
    }
}