package  ma.sir.pmp.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.pmp.bean.core.Tache;
import ma.sir.pmp.bean.history.TacheHistory;
import ma.sir.pmp.dao.criteria.core.TacheCriteria;
import ma.sir.pmp.dao.criteria.history.TacheHistoryCriteria;
import ma.sir.pmp.service.facade.admin.TacheAdminService;
import ma.sir.pmp.ws.converter.TacheConverter;
import ma.sir.pmp.ws.dto.TacheDto;
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

@Api("Manages tache services")
@RestController
@RequestMapping("/api/admin/tache/")
public class TacheRestAdmin  extends AbstractController<Tache, TacheDto, TacheHistory, TacheCriteria, TacheHistoryCriteria, TacheAdminService, TacheConverter> {


    @ApiOperation("upload one tache")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple taches")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all taches")
    @GetMapping("")
    public ResponseEntity<List<TacheDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all taches")
    @GetMapping("optimized")
    public ResponseEntity<List<TacheDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a tache by id")
    @GetMapping("id/{id}")
    public ResponseEntity<TacheDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  tache")
    @PostMapping("")
    public ResponseEntity<TacheDto> save(@RequestBody TacheDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  tache")
    @PutMapping("")
    public ResponseEntity<TacheDto> update(@RequestBody TacheDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of tache")
    @PostMapping("multiple")
    public ResponseEntity<List<TacheDto>> delete(@RequestBody List<TacheDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified tache")
    @DeleteMapping("")
    public ResponseEntity<TacheDto> delete(@RequestBody TacheDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified tache")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple taches by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by collaborateur id")
    @GetMapping("collaborateur/id/{id}")
    public List<Tache> findByCollaborateurId(@PathVariable Long id){
        return service.findByCollaborateurId(id);
    }
    @ApiOperation("delete by collaborateur id")
    @DeleteMapping("collaborateur/id/{id}")
    public int deleteByCollaborateurId(@PathVariable Long id){
        return service.deleteByCollaborateurId(id);
    }
    @ApiOperation("Finds taches by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<TacheDto>> findByCriteria(@RequestBody TacheCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated taches by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody TacheCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports taches by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody TacheCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets tache data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody TacheCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets tache history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets tache paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody TacheHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports tache history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody TacheHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets tache history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody TacheHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public TacheRestAdmin (TacheAdminService service, TacheConverter converter) {
        super(service, converter);
    }


}