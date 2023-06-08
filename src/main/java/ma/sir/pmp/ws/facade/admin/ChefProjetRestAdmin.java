package  ma.sir.pmp.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.pmp.bean.core.ChefProjet;
import ma.sir.pmp.bean.history.ChefProjetHistory;
import ma.sir.pmp.dao.criteria.core.ChefProjetCriteria;
import ma.sir.pmp.dao.criteria.history.ChefProjetHistoryCriteria;
import ma.sir.pmp.service.facade.admin.ChefProjetAdminService;
import ma.sir.pmp.ws.converter.ChefProjetConverter;
import ma.sir.pmp.ws.dto.ChefProjetDto;
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

@Api("Manages chefProjet services")
@RestController
@RequestMapping("/api/admin/chefProjet/")
public class ChefProjetRestAdmin  extends AbstractController<ChefProjet, ChefProjetDto, ChefProjetHistory, ChefProjetCriteria, ChefProjetHistoryCriteria, ChefProjetAdminService, ChefProjetConverter> {


    @ApiOperation("upload one chefProjet")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple chefProjets")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all chefProjets")
    @GetMapping("")
    public ResponseEntity<List<ChefProjetDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all chefProjets")
    @GetMapping("optimized")
    public ResponseEntity<List<ChefProjetDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a chefProjet by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ChefProjetDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  chefProjet")
    @PostMapping("")
    public ResponseEntity<ChefProjetDto> save(@RequestBody ChefProjetDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  chefProjet")
    @PutMapping("")
    public ResponseEntity<ChefProjetDto> update(@RequestBody ChefProjetDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of chefProjet")
    @PostMapping("multiple")
    public ResponseEntity<List<ChefProjetDto>> delete(@RequestBody List<ChefProjetDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified chefProjet")
    @DeleteMapping("")
    public ResponseEntity<ChefProjetDto> delete(@RequestBody ChefProjetDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified chefProjet")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple chefProjets by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds chefProjets by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ChefProjetDto>> findByCriteria(@RequestBody ChefProjetCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated chefProjets by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ChefProjetCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports chefProjets by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ChefProjetCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets chefProjet data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ChefProjetCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets chefProjet history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets chefProjet paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody ChefProjetHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports chefProjet history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody ChefProjetHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets chefProjet history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody ChefProjetHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public ChefProjetRestAdmin (ChefProjetAdminService service, ChefProjetConverter converter) {
        super(service, converter);
    }


}