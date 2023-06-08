package  ma.sir.pmp.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.pmp.bean.core.ProjetRessource;
import ma.sir.pmp.bean.history.ProjetRessourceHistory;
import ma.sir.pmp.dao.criteria.core.ProjetRessourceCriteria;
import ma.sir.pmp.dao.criteria.history.ProjetRessourceHistoryCriteria;
import ma.sir.pmp.service.facade.admin.ProjetRessourceAdminService;
import ma.sir.pmp.ws.converter.ProjetRessourceConverter;
import ma.sir.pmp.ws.dto.ProjetRessourceDto;
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

@Api("Manages projetRessource services")
@RestController
@RequestMapping("/api/admin/projetRessource/")
public class ProjetRessourceRestAdmin  extends AbstractController<ProjetRessource, ProjetRessourceDto, ProjetRessourceHistory, ProjetRessourceCriteria, ProjetRessourceHistoryCriteria, ProjetRessourceAdminService, ProjetRessourceConverter> {


    @ApiOperation("upload one projetRessource")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple projetRessources")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all projetRessources")
    @GetMapping("")
    public ResponseEntity<List<ProjetRessourceDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all projetRessources")
    @GetMapping("optimized")
    public ResponseEntity<List<ProjetRessourceDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a projetRessource by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ProjetRessourceDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  projetRessource")
    @PostMapping("")
    public ResponseEntity<ProjetRessourceDto> save(@RequestBody ProjetRessourceDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  projetRessource")
    @PutMapping("")
    public ResponseEntity<ProjetRessourceDto> update(@RequestBody ProjetRessourceDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of projetRessource")
    @PostMapping("multiple")
    public ResponseEntity<List<ProjetRessourceDto>> delete(@RequestBody List<ProjetRessourceDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified projetRessource")
    @DeleteMapping("")
    public ResponseEntity<ProjetRessourceDto> delete(@RequestBody ProjetRessourceDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified projetRessource")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple projetRessources by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by ressource id")
    @GetMapping("ressource/id/{id}")
    public List<ProjetRessource> findByRessourceId(@PathVariable Long id){
        return service.findByRessourceId(id);
    }
    @ApiOperation("delete by ressource id")
    @DeleteMapping("ressource/id/{id}")
    public int deleteByRessourceId(@PathVariable Long id){
        return service.deleteByRessourceId(id);
    }
    @ApiOperation("find by projet id")
    @GetMapping("projet/id/{id}")
    public List<ProjetRessource> findByProjetId(@PathVariable Long id){
        return service.findByProjetId(id);
    }
    @ApiOperation("delete by projet id")
    @DeleteMapping("projet/id/{id}")
    public int deleteByProjetId(@PathVariable Long id){
        return service.deleteByProjetId(id);
    }
    @ApiOperation("Finds projetRessources by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ProjetRessourceDto>> findByCriteria(@RequestBody ProjetRessourceCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated projetRessources by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ProjetRessourceCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports projetRessources by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ProjetRessourceCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets projetRessource data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ProjetRessourceCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets projetRessource history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets projetRessource paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody ProjetRessourceHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports projetRessource history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody ProjetRessourceHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets projetRessource history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody ProjetRessourceHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public ProjetRessourceRestAdmin (ProjetRessourceAdminService service, ProjetRessourceConverter converter) {
        super(service, converter);
    }


}