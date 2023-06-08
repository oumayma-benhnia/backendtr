package  ma.sir.pmp.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.pmp.bean.core.Projet;
import ma.sir.pmp.bean.history.ProjetHistory;
import ma.sir.pmp.dao.criteria.core.ProjetCriteria;
import ma.sir.pmp.dao.criteria.history.ProjetHistoryCriteria;
import ma.sir.pmp.service.facade.admin.ProjetAdminService;
import ma.sir.pmp.ws.converter.ProjetConverter;
import ma.sir.pmp.ws.dto.ProjetDto;
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

@Api("Manages projet services")
@RestController
@RequestMapping("/api/admin/projet/")
public class ProjetRestAdmin  extends AbstractController<Projet, ProjetDto, ProjetHistory, ProjetCriteria, ProjetHistoryCriteria, ProjetAdminService, ProjetConverter> {


    @ApiOperation("upload one projet")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple projets")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all projets")
    @GetMapping("")
    public ResponseEntity<List<ProjetDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all projets")
    @GetMapping("optimized")
    public ResponseEntity<List<ProjetDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a projet by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ProjetDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  projet")
    @PostMapping("")
    public ResponseEntity<ProjetDto> save(@RequestBody ProjetDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  projet")
    @PutMapping("")
    public ResponseEntity<ProjetDto> update(@RequestBody ProjetDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of projet")
    @PostMapping("multiple")
    public ResponseEntity<List<ProjetDto>> delete(@RequestBody List<ProjetDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified projet")
    @DeleteMapping("")
    public ResponseEntity<ProjetDto> delete(@RequestBody ProjetDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified projet")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple projets by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by typeProjet id")
    @GetMapping("typeProjet/id/{id}")
    public List<Projet> findByTypeProjetId(@PathVariable Long id){
        return service.findByTypeProjetId(id);
    }
    @ApiOperation("delete by typeProjet id")
    @DeleteMapping("typeProjet/id/{id}")
    public int deleteByTypeProjetId(@PathVariable Long id){
        return service.deleteByTypeProjetId(id);
    }
    @ApiOperation("find by client id")
    @GetMapping("client/id/{id}")
    public List<Projet> findByClientId(@PathVariable Long id){
        return service.findByClientId(id);
    }
    @ApiOperation("delete by client id")
    @DeleteMapping("client/id/{id}")
    public int deleteByClientId(@PathVariable Long id){
        return service.deleteByClientId(id);
    }
    @ApiOperation("find by chefProjet id")
    @GetMapping("chefProjet/id/{id}")
    public List<Projet> findByChefProjetId(@PathVariable Long id){
        return service.findByChefProjetId(id);
    }
    @ApiOperation("delete by chefProjet id")
    @DeleteMapping("chefProjet/id/{id}")
    public int deleteByChefProjetId(@PathVariable Long id){
        return service.deleteByChefProjetId(id);
    }
    @ApiOperation("Finds a projet and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<ProjetDto> findWithAssociatedLists(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @ApiOperation("Finds projets by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ProjetDto>> findByCriteria(@RequestBody ProjetCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated projets by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ProjetCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports projets by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ProjetCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets projet data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ProjetCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets projet history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets projet paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody ProjetHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports projet history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody ProjetHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets projet history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody ProjetHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public ProjetRestAdmin (ProjetAdminService service, ProjetConverter converter) {
        super(service, converter);
    }


}