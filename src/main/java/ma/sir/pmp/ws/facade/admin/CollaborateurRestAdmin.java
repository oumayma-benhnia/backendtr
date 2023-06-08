package  ma.sir.pmp.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.pmp.bean.core.Collaborateur;
import ma.sir.pmp.bean.history.CollaborateurHistory;
import ma.sir.pmp.dao.criteria.core.CollaborateurCriteria;
import ma.sir.pmp.dao.criteria.history.CollaborateurHistoryCriteria;
import ma.sir.pmp.service.facade.admin.CollaborateurAdminService;
import ma.sir.pmp.ws.converter.CollaborateurConverter;
import ma.sir.pmp.ws.dto.CollaborateurDto;
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

@Api("Manages collaborateur services")
@RestController
@RequestMapping("/api/admin/collaborateur/")
public class CollaborateurRestAdmin  extends AbstractController<Collaborateur, CollaborateurDto, CollaborateurHistory, CollaborateurCriteria, CollaborateurHistoryCriteria, CollaborateurAdminService, CollaborateurConverter> {


    @ApiOperation("upload one collaborateur")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple collaborateurs")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all collaborateurs")
    @GetMapping("")
    public ResponseEntity<List<CollaborateurDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all collaborateurs")
    @GetMapping("optimized")
    public ResponseEntity<List<CollaborateurDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a collaborateur by id")
    @GetMapping("id/{id}")
    public ResponseEntity<CollaborateurDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  collaborateur")
    @PostMapping("")
    public ResponseEntity<CollaborateurDto> save(@RequestBody CollaborateurDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  collaborateur")
    @PutMapping("")
    public ResponseEntity<CollaborateurDto> update(@RequestBody CollaborateurDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of collaborateur")
    @PostMapping("multiple")
    public ResponseEntity<List<CollaborateurDto>> delete(@RequestBody List<CollaborateurDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified collaborateur")
    @DeleteMapping("")
    public ResponseEntity<CollaborateurDto> delete(@RequestBody CollaborateurDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified collaborateur")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple collaborateurs by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds collaborateurs by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<CollaborateurDto>> findByCriteria(@RequestBody CollaborateurCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated collaborateurs by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody CollaborateurCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports collaborateurs by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody CollaborateurCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets collaborateur data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody CollaborateurCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets collaborateur history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets collaborateur paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody CollaborateurHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports collaborateur history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody CollaborateurHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets collaborateur history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody CollaborateurHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public CollaborateurRestAdmin (CollaborateurAdminService service, CollaborateurConverter converter) {
        super(service, converter);
    }


}