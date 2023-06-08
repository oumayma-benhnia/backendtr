package  ma.sir.pmp.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.pmp.bean.core.MoyenPaiement;
import ma.sir.pmp.bean.history.MoyenPaiementHistory;
import ma.sir.pmp.dao.criteria.core.MoyenPaiementCriteria;
import ma.sir.pmp.dao.criteria.history.MoyenPaiementHistoryCriteria;
import ma.sir.pmp.service.facade.admin.MoyenPaiementAdminService;
import ma.sir.pmp.ws.converter.MoyenPaiementConverter;
import ma.sir.pmp.ws.dto.MoyenPaiementDto;
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

@Api("Manages moyenPaiement services")
@RestController
@RequestMapping("/api/admin/moyenPaiement/")
public class MoyenPaiementRestAdmin  extends AbstractController<MoyenPaiement, MoyenPaiementDto, MoyenPaiementHistory, MoyenPaiementCriteria, MoyenPaiementHistoryCriteria, MoyenPaiementAdminService, MoyenPaiementConverter> {


    @ApiOperation("upload one moyenPaiement")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple moyenPaiements")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all moyenPaiements")
    @GetMapping("")
    public ResponseEntity<List<MoyenPaiementDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all moyenPaiements")
    @GetMapping("optimized")
    public ResponseEntity<List<MoyenPaiementDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a moyenPaiement by id")
    @GetMapping("id/{id}")
    public ResponseEntity<MoyenPaiementDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  moyenPaiement")
    @PostMapping("")
    public ResponseEntity<MoyenPaiementDto> save(@RequestBody MoyenPaiementDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  moyenPaiement")
    @PutMapping("")
    public ResponseEntity<MoyenPaiementDto> update(@RequestBody MoyenPaiementDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of moyenPaiement")
    @PostMapping("multiple")
    public ResponseEntity<List<MoyenPaiementDto>> delete(@RequestBody List<MoyenPaiementDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified moyenPaiement")
    @DeleteMapping("")
    public ResponseEntity<MoyenPaiementDto> delete(@RequestBody MoyenPaiementDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified moyenPaiement")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple moyenPaiements by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds moyenPaiements by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<MoyenPaiementDto>> findByCriteria(@RequestBody MoyenPaiementCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated moyenPaiements by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody MoyenPaiementCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports moyenPaiements by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody MoyenPaiementCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets moyenPaiement data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody MoyenPaiementCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets moyenPaiement history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets moyenPaiement paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody MoyenPaiementHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports moyenPaiement history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody MoyenPaiementHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets moyenPaiement history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody MoyenPaiementHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public MoyenPaiementRestAdmin (MoyenPaiementAdminService service, MoyenPaiementConverter converter) {
        super(service, converter);
    }


}