package  ma.sir.pmp.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.pmp.bean.core.Materiel;
import ma.sir.pmp.bean.history.MaterielHistory;
import ma.sir.pmp.dao.criteria.core.MaterielCriteria;
import ma.sir.pmp.dao.criteria.history.MaterielHistoryCriteria;
import ma.sir.pmp.service.facade.admin.MaterielAdminService;
import ma.sir.pmp.ws.converter.MaterielConverter;
import ma.sir.pmp.ws.dto.MaterielDto;
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

@Api("Manages materiel services")
@RestController
@RequestMapping("/api/admin/materiel/")
public class MaterielRestAdmin  extends AbstractController<Materiel, MaterielDto, MaterielHistory, MaterielCriteria, MaterielHistoryCriteria, MaterielAdminService, MaterielConverter> {


    @ApiOperation("upload one materiel")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple materiels")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all materiels")
    @GetMapping("")
    public ResponseEntity<List<MaterielDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all materiels")
    @GetMapping("optimized")
    public ResponseEntity<List<MaterielDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a materiel by id")
    @GetMapping("id/{id}")
    public ResponseEntity<MaterielDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  materiel")
    @PostMapping("")
    public ResponseEntity<MaterielDto> save(@RequestBody MaterielDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  materiel")
    @PutMapping("")
    public ResponseEntity<MaterielDto> update(@RequestBody MaterielDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of materiel")
    @PostMapping("multiple")
    public ResponseEntity<List<MaterielDto>> delete(@RequestBody List<MaterielDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified materiel")
    @DeleteMapping("")
    public ResponseEntity<MaterielDto> delete(@RequestBody MaterielDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified materiel")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple materiels by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by categorieMateriel id")
    @GetMapping("categorieMateriel/id/{id}")
    public List<Materiel> findByCategorieMaterielId(@PathVariable Long id){
        return service.findByCategorieMaterielId(id);
    }
    @ApiOperation("delete by categorieMateriel id")
    @DeleteMapping("categorieMateriel/id/{id}")
    public int deleteByCategorieMaterielId(@PathVariable Long id){
        return service.deleteByCategorieMaterielId(id);
    }
    @ApiOperation("Finds materiels by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<MaterielDto>> findByCriteria(@RequestBody MaterielCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated materiels by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody MaterielCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports materiels by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody MaterielCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets materiel data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody MaterielCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets materiel history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets materiel paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody MaterielHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports materiel history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody MaterielHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets materiel history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody MaterielHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public MaterielRestAdmin (MaterielAdminService service, MaterielConverter converter) {
        super(service, converter);
    }


}