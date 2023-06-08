package  ma.sir.pmp.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.pmp.bean.core.Comptable;
import ma.sir.pmp.bean.history.ComptableHistory;
import ma.sir.pmp.dao.criteria.core.ComptableCriteria;
import ma.sir.pmp.dao.criteria.history.ComptableHistoryCriteria;
import ma.sir.pmp.service.facade.admin.ComptableAdminService;
import ma.sir.pmp.ws.converter.ComptableConverter;
import ma.sir.pmp.ws.dto.ComptableDto;
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

@Api("Manages comptable services")
@RestController
@RequestMapping("/api/admin/comptable/")
public class ComptableRestAdmin  extends AbstractController<Comptable, ComptableDto, ComptableHistory, ComptableCriteria, ComptableHistoryCriteria, ComptableAdminService, ComptableConverter> {


    @ApiOperation("upload one comptable")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple comptables")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all comptables")
    @GetMapping("")
    public ResponseEntity<List<ComptableDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all comptables")
    @GetMapping("optimized")
    public ResponseEntity<List<ComptableDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a comptable by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ComptableDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  comptable")
    @PostMapping("")
    public ResponseEntity<ComptableDto> save(@RequestBody ComptableDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  comptable")
    @PutMapping("")
    public ResponseEntity<ComptableDto> update(@RequestBody ComptableDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of comptable")
    @PostMapping("multiple")
    public ResponseEntity<List<ComptableDto>> delete(@RequestBody List<ComptableDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified comptable")
    @DeleteMapping("")
    public ResponseEntity<ComptableDto> delete(@RequestBody ComptableDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified comptable")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple comptables by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds comptables by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ComptableDto>> findByCriteria(@RequestBody ComptableCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated comptables by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ComptableCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports comptables by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ComptableCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets comptable data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ComptableCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets comptable history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets comptable paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody ComptableHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports comptable history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody ComptableHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets comptable history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody ComptableHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public ComptableRestAdmin (ComptableAdminService service, ComptableConverter converter) {
        super(service, converter);
    }


}