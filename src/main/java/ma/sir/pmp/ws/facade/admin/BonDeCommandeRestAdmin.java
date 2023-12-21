package ma.sir.pmp.ws.facade.admin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.pmp.bean.core.BonDeCommande;
import ma.sir.pmp.bean.history.BonDeCommandeHistory;
import ma.sir.pmp.dao.criteria.core.BonDeCommandeCriteria;
import ma.sir.pmp.dao.criteria.history.BonDeCommandeHistoryCriteria;
import ma.sir.pmp.service.facade.admin.BonDeCommandeAdminService;
import ma.sir.pmp.ws.converter.BonDeCommandeConverter;
import ma.sir.pmp.ws.dto.BonDeCommandeDto;
import ma.sir.pmp.zynerator.controller.AbstractController;
import ma.sir.pmp.zynerator.dto.AuditEntityDto;
import ma.sir.pmp.zynerator.util.PaginatedList;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import ma.sir.pmp.zynerator.process.Result;
import org.springframework.web.multipart.MultipartFile;
import ma.sir.pmp.zynerator.dto.FileTempDto;

import java.util.List;

@Api("Manages Bon de Commande services")
@RestController
@RequestMapping("/api/admin/bon-de-commande/")
public class BonDeCommandeRestAdmin extends AbstractController<BonDeCommande, BonDeCommandeDto, BonDeCommandeHistory, BonDeCommandeCriteria, BonDeCommandeHistoryCriteria, BonDeCommandeAdminService, BonDeCommandeConverter> {

    @ApiOperation("upload one Bon de Commande")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }

    @ApiOperation("upload multiple Bon de Commandes")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all Bon de Commandes")
    @GetMapping("")
    public ResponseEntity<List<BonDeCommandeDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all Bon de Commandes")
    @GetMapping("optimized")
    public ResponseEntity<List<BonDeCommandeDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a Bon de Commande by id")
    @GetMapping("id/{id}")
    public ResponseEntity<BonDeCommandeDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }

    @ApiOperation("Saves the specified Bon de Commande")
    @PostMapping("")
    public ResponseEntity<BonDeCommandeDto> save(@RequestBody BonDeCommandeDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified Bon de Commande")
    @PutMapping("")
    public ResponseEntity<BonDeCommandeDto> update(@RequestBody BonDeCommandeDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of Bon de Commande")
    @PostMapping("multiple")
    public ResponseEntity<List<BonDeCommandeDto>> delete(@RequestBody List<BonDeCommandeDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }

    @ApiOperation("Delete the specified Bon de Commande")
    @DeleteMapping("")
    public ResponseEntity<BonDeCommandeDto> delete(@RequestBody BonDeCommandeDto dto) throws Exception {
        return super.delete(dto);
    }

    @ApiOperation("Delete the specified Bon de Commande")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }

    @ApiOperation("Delete multiple Bon de Commandes by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
        return super.deleteByIdIn(ids);
    }

    @ApiOperation("find by client id")
    @GetMapping("client/id/{id}")
    public List<BonDeCommande> findByClientId(@PathVariable Long id) {
        return service.findByClientId(id);
    }

    @ApiOperation("Finds a Bon de Commande and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<BonDeCommandeDto> findWithAssociatedLists(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @ApiOperation("Finds Bon de Commandes by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<BonDeCommandeDto>> findByCriteria(@RequestBody BonDeCommandeCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated Bon de Commandes by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody BonDeCommandeCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports Bon de Commandes by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody BonDeCommandeCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets Bon de Commande data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody BonDeCommandeCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets Bon de Commande history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets Bon de Commande paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody BonDeCommandeHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports Bon de Commande history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody BonDeCommandeHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets Bon de Commande history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody BonDeCommandeHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }

    public BonDeCommandeRestAdmin(BonDeCommandeAdminService service, BonDeCommandeConverter converter) {
        super(service, converter);
    }
}