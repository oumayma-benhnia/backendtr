package ma.sir.pmp.ws.facade.admin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.pmp.bean.core.Employe;
import ma.sir.pmp.bean.core.Stagaire;

import ma.sir.pmp.bean.history.StagaireHistory;

import ma.sir.pmp.dao.criteria.core.StagaireCriteria;

import ma.sir.pmp.dao.criteria.history.StagaireHistoryCriteria;

import ma.sir.pmp.service.facade.admin.StagaireAdminService;

import ma.sir.pmp.ws.converter.StagaireConverter;

import ma.sir.pmp.ws.dto.EmployeDto;
import ma.sir.pmp.ws.dto.StagaireDto;

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

@Api("Manages stagaire services")
@RestController
@RequestMapping("/api/admin/stagaire/")
public class StagaireRestAdmin extends AbstractController<Stagaire, StagaireDto, StagaireHistory, StagaireCriteria, StagaireHistoryCriteria, StagaireAdminService, StagaireConverter> {

    public StagaireRestAdmin(StagaireAdminService service, StagaireConverter converter) {
        super(service, converter);
    }

    @ApiOperation("upload one stagaire")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }

    @ApiOperation("upload multiple stagaires")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all stagaires")
    @GetMapping("")
    public ResponseEntity<List<StagaireDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all stagaires")
    @GetMapping("optimized")
    public ResponseEntity<List<StagaireDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a stagaire by id")
    @GetMapping("id/{id}")
    public ResponseEntity<StagaireDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }

    @ApiOperation("Saves the specified stagaire")
    @PostMapping("")
    public ResponseEntity<StagaireDto> save(@RequestBody StagaireDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified stagaire")
    @PutMapping("")
    public ResponseEntity<StagaireDto> update(@RequestBody StagaireDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of stagaire")
    @PostMapping("multiple")
    public ResponseEntity<List<StagaireDto>> delete(@RequestBody List<StagaireDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }

    @ApiOperation("Delete the specified stagaire")
    @DeleteMapping("")
    public ResponseEntity<StagaireDto> delete(@RequestBody StagaireDto dto) throws Exception {
        return super.delete(dto);
    }

    @ApiOperation("Delete the specified stagaire")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }

    @ApiOperation("Delete multiple stagaires by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
        return super.deleteByIdIn(ids);
    }

    @ApiOperation("Finds stagaires by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<StagaireDto>> findByCriteria(@RequestBody StagaireCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated stagaires by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody StagaireCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports stagaires by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody StagaireCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets stagaire data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody StagaireCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets stagaire history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets stagaire paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody StagaireHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports stagaire history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody StagaireHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets stagaire history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody StagaireHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    @ApiOperation("Find by nom and prenom")
    @GetMapping("nomAndPrenom")
    public ResponseEntity<StagaireDto> findByNomAndPrenom(@RequestParam String nom, @RequestParam String prenom) throws Exception {
        Stagaire stagaire = service.findByNomAndPrenom(nom, prenom);
        StagaireDto stagaireDto = converter.toDto(stagaire);
        return ResponseEntity.ok(stagaireDto);
    }



}





