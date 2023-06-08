package  ma.sir.pmp.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.pmp.bean.core.Ressource;
import ma.sir.pmp.bean.history.RessourceHistory;
import ma.sir.pmp.dao.criteria.core.RessourceCriteria;
import ma.sir.pmp.dao.criteria.history.RessourceHistoryCriteria;
import ma.sir.pmp.service.facade.admin.RessourceAdminService;
import ma.sir.pmp.ws.converter.RessourceConverter;
import ma.sir.pmp.ws.dto.RessourceDto;
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

@Api("Manages ressource services")
@RestController
@RequestMapping("/api/admin/ressource/")
public class RessourceRestAdmin  extends AbstractController<Ressource, RessourceDto, RessourceHistory, RessourceCriteria, RessourceHistoryCriteria, RessourceAdminService, RessourceConverter> {


    @ApiOperation("upload one ressource")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple ressources")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all ressources")
    @GetMapping("")
    public ResponseEntity<List<RessourceDto>> findAll() throws Exception {
        return super.findAll();
    }


    @ApiOperation("Finds a ressource by id")
    @GetMapping("id/{id}")
    public ResponseEntity<RessourceDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  ressource")
    @PostMapping("")
    public ResponseEntity<RessourceDto> save(@RequestBody RessourceDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  ressource")
    @PutMapping("")
    public ResponseEntity<RessourceDto> update(@RequestBody RessourceDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of ressource")
    @PostMapping("multiple")
    public ResponseEntity<List<RessourceDto>> delete(@RequestBody List<RessourceDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified ressource")
    @DeleteMapping("")
    public ResponseEntity<RessourceDto> delete(@RequestBody RessourceDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified ressource")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple ressources by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by fournisseur id")
    @GetMapping("fournisseur/id/{id}")
    public List<Ressource> findByFournisseurId(@PathVariable Long id){
        return service.findByFournisseurId(id);
    }
    @ApiOperation("delete by fournisseur id")
    @DeleteMapping("fournisseur/id/{id}")
    public int deleteByFournisseurId(@PathVariable Long id){
        return service.deleteByFournisseurId(id);
    }
    @ApiOperation("find by materiel id")
    @GetMapping("materiel/id/{id}")
    public List<Ressource> findByMaterielId(@PathVariable Long id){
        return service.findByMaterielId(id);
    }
    @ApiOperation("delete by materiel id")
    @DeleteMapping("materiel/id/{id}")
    public int deleteByMaterielId(@PathVariable Long id){
        return service.deleteByMaterielId(id);
    }
    @ApiOperation("find by collaborateur id")
    @GetMapping("collaborateur/id/{id}")
    public List<Ressource> findByCollaborateurId(@PathVariable Long id){
        return service.findByCollaborateurId(id);
    }
    @ApiOperation("delete by collaborateur id")
    @DeleteMapping("collaborateur/id/{id}")
    public int deleteByCollaborateurId(@PathVariable Long id){
        return service.deleteByCollaborateurId(id);
    }
    @ApiOperation("find by entiteAdministrative id")
    @GetMapping("entiteAdministrative/id/{id}")
    public List<Ressource> findByEntiteAdministrativeId(@PathVariable Long id){
        return service.findByEntiteAdministrativeId(id);
    }
    @ApiOperation("delete by entiteAdministrative id")
    @DeleteMapping("entiteAdministrative/id/{id}")
    public int deleteByEntiteAdministrativeId(@PathVariable Long id){
        return service.deleteByEntiteAdministrativeId(id);
    }
    @ApiOperation("Finds ressources by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<RessourceDto>> findByCriteria(@RequestBody RessourceCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated ressources by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody RessourceCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports ressources by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody RessourceCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets ressource data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody RessourceCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets ressource history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets ressource paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody RessourceHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports ressource history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody RessourceHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets ressource history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody RessourceHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public RessourceRestAdmin (RessourceAdminService service, RessourceConverter converter) {
        super(service, converter);
    }


}