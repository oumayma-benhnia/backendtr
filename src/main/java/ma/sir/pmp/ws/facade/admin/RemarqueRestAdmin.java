package  ma.sir.pmp.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.pmp.bean.core.Remarque;
import ma.sir.pmp.bean.history.RemarqueHistory;
import ma.sir.pmp.dao.criteria.core.RemarqueCriteria;
import ma.sir.pmp.dao.criteria.history.RemarqueHistoryCriteria;
import ma.sir.pmp.service.facade.admin.RemarqueAdminService;
import ma.sir.pmp.ws.converter.RemarqueConverter;
import ma.sir.pmp.ws.dto.RemarqueDto;
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

@Api("Manages remarque services")
@RestController
@RequestMapping("/api/admin/remarque/")
public class RemarqueRestAdmin  extends AbstractController<Remarque, RemarqueDto, RemarqueHistory, RemarqueCriteria, RemarqueHistoryCriteria, RemarqueAdminService, RemarqueConverter> {


    @ApiOperation("upload one remarque")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple remarques")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all remarques")
    @GetMapping("")
    public ResponseEntity<List<RemarqueDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all remarques")
    @GetMapping("optimized")
    public ResponseEntity<List<RemarqueDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a remarque by id")
    @GetMapping("id/{id}")
    public ResponseEntity<RemarqueDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  remarque")
    @PostMapping("")
    public ResponseEntity<RemarqueDto> save(@RequestBody RemarqueDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  remarque")
    @PutMapping("")
    public ResponseEntity<RemarqueDto> update(@RequestBody RemarqueDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of remarque")
    @PostMapping("multiple")
    public ResponseEntity<List<RemarqueDto>> delete(@RequestBody List<RemarqueDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified remarque")
    @DeleteMapping("")
    public ResponseEntity<RemarqueDto> delete(@RequestBody RemarqueDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified remarque")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple remarques by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by projet id")
    @GetMapping("projet/id/{id}")
    public List<Remarque> findByProjetId(@PathVariable Long id){
        return service.findByProjetId(id);
    }
    @ApiOperation("delete by projet id")
    @DeleteMapping("projet/id/{id}")
    public int deleteByProjetId(@PathVariable Long id){
        return service.deleteByProjetId(id);
    }
    @ApiOperation("Finds remarques by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<RemarqueDto>> findByCriteria(@RequestBody RemarqueCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated remarques by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody RemarqueCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports remarques by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody RemarqueCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets remarque data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody RemarqueCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets remarque history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets remarque paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody RemarqueHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports remarque history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody RemarqueHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets remarque history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody RemarqueHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public RemarqueRestAdmin (RemarqueAdminService service, RemarqueConverter converter) {
        super(service, converter);
    }


}