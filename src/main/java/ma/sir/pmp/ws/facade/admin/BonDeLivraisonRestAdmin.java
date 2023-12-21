package ma.sir.pmp.ws.facade.admin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.pmp.bean.core.BonDeLivraison;
import ma.sir.pmp.bean.history.BonDeLivraisonHistory;
import ma.sir.pmp.dao.criteria.core.BonDeLivraisonCriteria;
import ma.sir.pmp.dao.criteria.history.BonDeLivraisonHistoryCriteria;
import ma.sir.pmp.service.facade.admin.BonDeLivraisonAdminService;
import ma.sir.pmp.ws.converter.BonDeLivraisonConverter;
import ma.sir.pmp.ws.dto.BonDeLivraisonDto;
import ma.sir.pmp.zynerator.controller.AbstractController;
import ma.sir.pmp.zynerator.dto.AuditEntityDto;
import ma.sir.pmp.zynerator.util.PaginatedList;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ma.sir.pmp.zynerator.dto.FileTempDto;

import java.time.LocalDateTime;
import java.util.List;

@Api("Manages bon de livraison services")
@RestController
@RequestMapping("/api/admin/bon-de-livraison/")
public class BonDeLivraisonRestAdmin extends AbstractController<BonDeLivraison, BonDeLivraisonDto, BonDeLivraisonHistory, BonDeLivraisonCriteria, BonDeLivraisonHistoryCriteria, BonDeLivraisonAdminService, BonDeLivraisonConverter> {

    @ApiOperation("upload one bon de livraison")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }

    @ApiOperation("upload multiple bon de livraisons")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all bon de livraisons")
    @GetMapping("")
    public ResponseEntity<List<BonDeLivraisonDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all bon de livraisons")
    @GetMapping("optimized")
    public ResponseEntity<List<BonDeLivraisonDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a bon de livraison by id")
    @GetMapping("id/{id}")
    public ResponseEntity<BonDeLivraisonDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }

    @ApiOperation("Saves the specified bon de livraison")
    @PostMapping("")
    public ResponseEntity<BonDeLivraisonDto> save(@RequestBody BonDeLivraisonDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified bon de livraison")
    @PutMapping("")
    public ResponseEntity<BonDeLivraisonDto> update(@RequestBody BonDeLivraisonDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of bon de livraisons")
    @PostMapping("multiple")
    public ResponseEntity<List<BonDeLivraisonDto>> delete(@RequestBody List<BonDeLivraisonDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }

    @ApiOperation("Delete the specified bon de livraison")
    @DeleteMapping("")
    public ResponseEntity<BonDeLivraisonDto> delete(@RequestBody BonDeLivraisonDto dto) throws Exception {
        return super.delete(dto);
    }

    @ApiOperation("Delete the specified bon de livraison")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }

    @ApiOperation("Finds bon de livraisons by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<BonDeLivraisonDto>> findByCriteria(@RequestBody BonDeLivraisonCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated bon de livraisons by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody BonDeLivraisonCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports bon de livraisons by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody BonDeLivraisonCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets bon de livraison data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody BonDeLivraisonCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets bon de livraison history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets bon de livraison paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody BonDeLivraisonHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports bon de livraison history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody BonDeLivraisonHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets bon de livraison history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody BonDeLivraisonHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    @ApiOperation("Find bon de livraison by fournisseur id")
    @GetMapping("fournisseur/id/{id}")
    public List<BonDeLivraison> findByFournisseurId(@PathVariable Long id) {
        return service.findByFournisseurId(id);
    }

    @ApiOperation("Find bon de livraison by client id")
    @GetMapping("client/id/{id}")
    public List<BonDeLivraison> findByClientId(@PathVariable Long id) {
        return service.findByClientId(id);
    }

    @ApiOperation("Find bon de livraison by date livraison")
    @GetMapping("dateLivraison/{dateLivraison}")
    public BonDeLivraison findByDateLivraison(@PathVariable LocalDateTime dateLivraison) {
        return service.findByDateLivraison(dateLivraison);
    }

    public BonDeLivraisonRestAdmin(BonDeLivraisonAdminService service, BonDeLivraisonConverter converter) {
        super(service, converter);
    }
}