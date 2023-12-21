package ma.sir.pmp.ws.facade.admin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.pmp.bean.core.Devis;
import ma.sir.pmp.bean.history.DevisHistory;
import ma.sir.pmp.dao.criteria.core.DevisCriteria;
import ma.sir.pmp.dao.criteria.history.DevisHistoryCriteria;
import ma.sir.pmp.service.facade.admin.DevisAdminService;
import ma.sir.pmp.ws.converter.DevisConverter;
import ma.sir.pmp.ws.dto.DevisDto;
import ma.sir.pmp.zynerator.controller.AbstractController;
import ma.sir.pmp.zynerator.dto.AuditEntityDto;
import ma.sir.pmp.zynerator.util.PaginatedList;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import ma.sir.pmp.zynerator.dto.FileTempDto;

@Api("Manages devis services")
@RestController
@RequestMapping("/api/admin/devis/")
public class DevisRestAdmin extends AbstractController<Devis, DevisDto, DevisHistory, DevisCriteria, DevisHistoryCriteria, DevisAdminService, DevisConverter> {

    @ApiOperation("upload one devis")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }

    @ApiOperation("upload multiple devis")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all devis")
    @GetMapping("")
    public ResponseEntity<List<DevisDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all devis")
    @GetMapping("optimized")
    public ResponseEntity<List<DevisDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a devis by id")
    @GetMapping("id/{id}")
    public ResponseEntity<DevisDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }

    @ApiOperation("Saves the specified devis")
    @PostMapping("")
    public ResponseEntity<DevisDto> save(@RequestBody DevisDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified devis")
    @PutMapping("")
    public ResponseEntity<DevisDto> update(@RequestBody DevisDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of devis")
    @PostMapping("multiple")
    public ResponseEntity<List<DevisDto>> delete(@RequestBody List<DevisDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }

    @ApiOperation("Delete the specified devis")
    @DeleteMapping("")
    public ResponseEntity<DevisDto> delete(@RequestBody DevisDto dto) throws Exception {
        return super.delete(dto);
    }

    @ApiOperation("Delete the specified devis")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }

    @ApiOperation("Delete multiple devis by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
        return super.deleteByIdIn(ids);
    }

    @ApiOperation("find by projet id")
    @GetMapping("projet/id/{id}")
    public List<Devis> findByProjetId(@PathVariable Long id) {
        return service.findByProjetId(id);
    }

    @ApiOperation("delete by projet id")
    @DeleteMapping("projet/id/{id}")
    public int deleteByProjetId(@PathVariable Long id) {
        return service.deleteByProjetId(id);
    }

    @ApiOperation("Finds devis by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<DevisDto>> findByCriteria(@RequestBody DevisCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated devis by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody DevisCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports devis by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody DevisCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets devis data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody DevisCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets devis history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets devis paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody DevisHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports devis history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody DevisHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets devis history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody DevisHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }

    public DevisRestAdmin(DevisAdminService service, DevisConverter converter) {
        super(service, converter);
    }
}