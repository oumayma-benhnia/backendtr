package  ma.sir.pmp.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.pmp.bean.core.Fournisseur;
import ma.sir.pmp.bean.history.FournisseurHistory;
import ma.sir.pmp.dao.criteria.core.FournisseurCriteria;
import ma.sir.pmp.dao.criteria.history.FournisseurHistoryCriteria;
import ma.sir.pmp.service.facade.admin.FournisseurAdminService;
import ma.sir.pmp.ws.converter.FournisseurConverter;
import ma.sir.pmp.ws.dto.FournisseurDto;
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

@Api("Manages fournisseur services")
@RestController
@RequestMapping("/api/admin/fournisseur/")
public class FournisseurRestAdmin  extends AbstractController<Fournisseur, FournisseurDto, FournisseurHistory, FournisseurCriteria, FournisseurHistoryCriteria, FournisseurAdminService, FournisseurConverter> {


    @ApiOperation("upload one fournisseur")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple fournisseurs")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all fournisseurs")
    @GetMapping("")
    public ResponseEntity<List<FournisseurDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all fournisseurs")
    @GetMapping("optimized")
    public ResponseEntity<List<FournisseurDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a fournisseur by id")
    @GetMapping("id/{id}")
    public ResponseEntity<FournisseurDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  fournisseur")
    @PostMapping("")
    public ResponseEntity<FournisseurDto> save(@RequestBody FournisseurDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  fournisseur")
    @PutMapping("")
    public ResponseEntity<FournisseurDto> update(@RequestBody FournisseurDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of fournisseur")
    @PostMapping("multiple")
    public ResponseEntity<List<FournisseurDto>> delete(@RequestBody List<FournisseurDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified fournisseur")
    @DeleteMapping("")
    public ResponseEntity<FournisseurDto> delete(@RequestBody FournisseurDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified fournisseur")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple fournisseurs by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds fournisseurs by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<FournisseurDto>> findByCriteria(@RequestBody FournisseurCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated fournisseurs by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody FournisseurCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports fournisseurs by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody FournisseurCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets fournisseur data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody FournisseurCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets fournisseur history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets fournisseur paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody FournisseurHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports fournisseur history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody FournisseurHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets fournisseur history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody FournisseurHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public FournisseurRestAdmin (FournisseurAdminService service, FournisseurConverter converter) {
        super(service, converter);
    }


}