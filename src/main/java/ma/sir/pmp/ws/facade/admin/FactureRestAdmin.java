package  ma.sir.pmp.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.pmp.bean.core.Facture;
import ma.sir.pmp.bean.history.FactureHistory;
import ma.sir.pmp.dao.criteria.core.FactureCriteria;
import ma.sir.pmp.dao.criteria.history.FactureHistoryCriteria;
import ma.sir.pmp.service.facade.admin.FactureAdminService;
import ma.sir.pmp.ws.converter.FactureConverter;
import ma.sir.pmp.ws.dto.FactureDto;
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

@Api("Manages facture services")
@RestController
@RequestMapping("/api/admin/facture/")
public class FactureRestAdmin  extends AbstractController<Facture, FactureDto, FactureHistory, FactureCriteria, FactureHistoryCriteria, FactureAdminService, FactureConverter> {


    @ApiOperation("upload one facture")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple factures")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all factures")
    @GetMapping("")
    public ResponseEntity<List<FactureDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all factures")
    @GetMapping("optimized")
    public ResponseEntity<List<FactureDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a facture by id")
    @GetMapping("id/{id}")
    public ResponseEntity<FactureDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  facture")
    @PostMapping("")
    public ResponseEntity<FactureDto> save(@RequestBody FactureDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  facture")
    @PutMapping("")
    public ResponseEntity<FactureDto> update(@RequestBody FactureDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of facture")
    @PostMapping("multiple")
    public ResponseEntity<List<FactureDto>> delete(@RequestBody List<FactureDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified facture")
    @DeleteMapping("")
    public ResponseEntity<FactureDto> delete(@RequestBody FactureDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified facture")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple factures by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by comptable id")
    @GetMapping("comptable/id/{id}")
    public List<Facture> findByComptableId(@PathVariable Long id){
        return service.findByComptableId(id);
    }
    @ApiOperation("delete by comptable id")
    @DeleteMapping("comptable/id/{id}")
    public int deleteByComptableId(@PathVariable Long id){
        return service.deleteByComptableId(id);
    }
    @ApiOperation("find by projet id")
    @GetMapping("projet/id/{id}")
    public List<Facture> findByProjetId(@PathVariable Long id){
        return service.findByProjetId(id);
    }
    @ApiOperation("delete by projet id")
    @DeleteMapping("projet/id/{id}")
    public int deleteByProjetId(@PathVariable Long id){
        return service.deleteByProjetId(id);
    }
    @ApiOperation("Finds factures by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<FactureDto>> findByCriteria(@RequestBody FactureCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated factures by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody FactureCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports factures by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody FactureCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets facture data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody FactureCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets facture history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets facture paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody FactureHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports facture history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody FactureHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets facture history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody FactureHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public FactureRestAdmin (FactureAdminService service, FactureConverter converter) {
        super(service, converter);
    }


}