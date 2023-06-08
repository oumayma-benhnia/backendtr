package  ma.sir.pmp.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.pmp.bean.core.CategorieMateriel;
import ma.sir.pmp.bean.history.CategorieMaterielHistory;
import ma.sir.pmp.dao.criteria.core.CategorieMaterielCriteria;
import ma.sir.pmp.dao.criteria.history.CategorieMaterielHistoryCriteria;
import ma.sir.pmp.service.facade.admin.CategorieMaterielAdminService;
import ma.sir.pmp.ws.converter.CategorieMaterielConverter;
import ma.sir.pmp.ws.dto.CategorieMaterielDto;
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

@Api("Manages categorieMateriel services")
@RestController
@RequestMapping("/api/admin/categorieMateriel/")
public class CategorieMaterielRestAdmin  extends AbstractController<CategorieMateriel, CategorieMaterielDto, CategorieMaterielHistory, CategorieMaterielCriteria, CategorieMaterielHistoryCriteria, CategorieMaterielAdminService, CategorieMaterielConverter> {


    @ApiOperation("upload one categorieMateriel")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple categorieMateriels")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all categorieMateriels")
    @GetMapping("")
    public ResponseEntity<List<CategorieMaterielDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all categorieMateriels")
    @GetMapping("optimized")
    public ResponseEntity<List<CategorieMaterielDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a categorieMateriel by id")
    @GetMapping("id/{id}")
    public ResponseEntity<CategorieMaterielDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  categorieMateriel")
    @PostMapping("")
    public ResponseEntity<CategorieMaterielDto> save(@RequestBody CategorieMaterielDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  categorieMateriel")
    @PutMapping("")
    public ResponseEntity<CategorieMaterielDto> update(@RequestBody CategorieMaterielDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of categorieMateriel")
    @PostMapping("multiple")
    public ResponseEntity<List<CategorieMaterielDto>> delete(@RequestBody List<CategorieMaterielDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified categorieMateriel")
    @DeleteMapping("")
    public ResponseEntity<CategorieMaterielDto> delete(@RequestBody CategorieMaterielDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified categorieMateriel")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple categorieMateriels by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds categorieMateriels by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<CategorieMaterielDto>> findByCriteria(@RequestBody CategorieMaterielCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated categorieMateriels by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody CategorieMaterielCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports categorieMateriels by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody CategorieMaterielCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets categorieMateriel data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody CategorieMaterielCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets categorieMateriel history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets categorieMateriel paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody CategorieMaterielHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports categorieMateriel history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody CategorieMaterielHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets categorieMateriel history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody CategorieMaterielHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public CategorieMaterielRestAdmin (CategorieMaterielAdminService service, CategorieMaterielConverter converter) {
        super(service, converter);
    }


}