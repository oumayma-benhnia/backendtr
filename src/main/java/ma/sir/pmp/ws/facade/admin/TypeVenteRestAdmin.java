package ma.sir.pmp.ws.facade.admin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.pmp.bean.core.TypeVente;
import ma.sir.pmp.bean.history.TypeVenteHistory;
import ma.sir.pmp.dao.criteria.core.TypeVenteCriteria;
import ma.sir.pmp.dao.criteria.history.TypeVenteHistoryCriteria;
import ma.sir.pmp.service.facade.admin.TypeVenteAdminService;
import ma.sir.pmp.ws.converter.TypeVenteConverter;
import ma.sir.pmp.ws.dto.TypeVenteDto;
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

@Api("Manages typeVente services")
@RestController
@RequestMapping("/api/admin/typeVente/")  // Adjusted the URL mapping
public class TypeVenteRestAdmin extends AbstractController<TypeVente, TypeVenteDto, TypeVenteHistory, TypeVenteCriteria, TypeVenteHistoryCriteria, TypeVenteAdminService, TypeVenteConverter> {

    @ApiOperation("upload one typeVente")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }

    @ApiOperation("upload multiple typeVentes")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all typeVentes")
    @GetMapping("")
    public ResponseEntity<List<TypeVenteDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all typeVentes")
    @GetMapping("optimized")
    public ResponseEntity<List<TypeVenteDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a typeVente by id")
    @GetMapping("id/{id}")
    public ResponseEntity<TypeVenteDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }

    @ApiOperation("Saves the specified typeVente")
    @PostMapping("")
    public ResponseEntity<TypeVenteDto> save(@RequestBody TypeVenteDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified typeVente")
    @PutMapping("")
    public ResponseEntity<TypeVenteDto> update(@RequestBody TypeVenteDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of typeVente")
    @PostMapping("multiple")
    public ResponseEntity<List<TypeVenteDto>> delete(@RequestBody List<TypeVenteDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }

    @ApiOperation("Delete the specified typeVente")
    @DeleteMapping("")
    public ResponseEntity<TypeVenteDto> delete(@RequestBody TypeVenteDto dto) throws Exception {
        return super.delete(dto);
    }

    @ApiOperation("Delete the specified typeVente")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }

    @ApiOperation("Delete multiple typeVentes by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
        return super.deleteByIdIn(ids);
    }

    @ApiOperation("Finds typeVentes by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<TypeVenteDto>> findByCriteria(@RequestBody TypeVenteCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated typeVentes by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody TypeVenteCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports typeVentes by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody TypeVenteCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets typeVente data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody TypeVenteCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets typeVente history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets typeVente paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody TypeVenteHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports typeVente history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody TypeVenteHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets typeVente history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody TypeVenteHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }

    public TypeVenteRestAdmin(TypeVenteAdminService service, TypeVenteConverter converter) {
        super(service, converter);
    }
}