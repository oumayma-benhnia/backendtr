package ma.sir.pmp.ws.facade.admin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.pmp.bean.core.Employe;
import ma.sir.pmp.bean.history.EmployeHistory;
import ma.sir.pmp.dao.criteria.core.EmployeCriteria;
import ma.sir.pmp.dao.criteria.history.EmployeHistoryCriteria;
import ma.sir.pmp.service.facade.admin.EmployeAdminService;
import ma.sir.pmp.ws.converter.EmployeConverter;
import ma.sir.pmp.ws.dto.EmployeDto;
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

@Api("Manages employe services")
@RestController
@RequestMapping("/api/admin/employe/")
public class EmployeRestAdmin extends AbstractController<Employe, EmployeDto, EmployeHistory, EmployeCriteria, EmployeHistoryCriteria, EmployeAdminService, EmployeConverter> {

    @ApiOperation("upload one employe")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }

    @ApiOperation("upload multiple employes")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all employes")
    @GetMapping("")
    public ResponseEntity<List<EmployeDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all employes")
    @GetMapping("optimized")
    public ResponseEntity<List<EmployeDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds an employe by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EmployeDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }

    @ApiOperation("Saves the specified employe")
    @PostMapping("")
    public ResponseEntity<EmployeDto> save(@RequestBody EmployeDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified employe")
    @PutMapping("")
    public ResponseEntity<EmployeDto> update(@RequestBody EmployeDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of employe")
    @PostMapping("multiple")
    public ResponseEntity<List<EmployeDto>> delete(@RequestBody List<EmployeDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }

    @ApiOperation("Delete the specified employe")
    @DeleteMapping("")
    public ResponseEntity<EmployeDto> delete(@RequestBody EmployeDto dto) throws Exception {
        return super.delete(dto);
    }

    @ApiOperation("Delete the specified employe")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }

    @ApiOperation("Delete multiple employes by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
        return super.deleteByIdIn(ids);
    }

    @ApiOperation("Finds employes by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<EmployeDto>> findByCriteria(@RequestBody EmployeCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated employes by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody EmployeCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports employes by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody EmployeCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets employe data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody EmployeCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets employe history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets employe paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody EmployeHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports employe history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody EmployeHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets employe history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody EmployeHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    @ApiOperation("Find by nom and prenom")
    @GetMapping("nomAndPrenom")
    public ResponseEntity<EmployeDto> findByNomAndPrenom(@RequestParam String nom, @RequestParam String prenom) throws Exception {
        Employe employe = service.findByNomAndPrenom(nom, prenom);
        EmployeDto employeDto = converter.toDto(employe);
        return ResponseEntity.ok(employeDto);
    }
    public EmployeRestAdmin(EmployeAdminService service, EmployeConverter converter) {
        super(service, converter);
    }
}