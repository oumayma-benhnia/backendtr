package  ma.sir.pmp.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.pmp.bean.core.TypeProjet;
import ma.sir.pmp.bean.history.TypeProjetHistory;
import ma.sir.pmp.dao.criteria.core.TypeProjetCriteria;
import ma.sir.pmp.dao.criteria.history.TypeProjetHistoryCriteria;
import ma.sir.pmp.service.facade.admin.TypeProjetAdminService;
import ma.sir.pmp.ws.converter.TypeProjetConverter;
import ma.sir.pmp.ws.dto.TypeProjetDto;
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

@Api("Manages typeProjet services")
@RestController
@RequestMapping("/api/admin/typeProjet/")
public class TypeProjetRestAdmin  extends AbstractController<TypeProjet, TypeProjetDto, TypeProjetHistory, TypeProjetCriteria, TypeProjetHistoryCriteria, TypeProjetAdminService, TypeProjetConverter> {


    @ApiOperation("upload one typeProjet")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple typeProjets")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all typeProjets")
    @GetMapping("")
    public ResponseEntity<List<TypeProjetDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all typeProjets")
    @GetMapping("optimized")
    public ResponseEntity<List<TypeProjetDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a typeProjet by id")
    @GetMapping("id/{id}")
    public ResponseEntity<TypeProjetDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  typeProjet")
    @PostMapping("")
    public ResponseEntity<TypeProjetDto> save(@RequestBody TypeProjetDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  typeProjet")
    @PutMapping("")
    public ResponseEntity<TypeProjetDto> update(@RequestBody TypeProjetDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of typeProjet")
    @PostMapping("multiple")
    public ResponseEntity<List<TypeProjetDto>> delete(@RequestBody List<TypeProjetDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified typeProjet")
    @DeleteMapping("")
    public ResponseEntity<TypeProjetDto> delete(@RequestBody TypeProjetDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified typeProjet")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple typeProjets by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds typeProjets by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<TypeProjetDto>> findByCriteria(@RequestBody TypeProjetCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated typeProjets by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody TypeProjetCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports typeProjets by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody TypeProjetCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets typeProjet data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody TypeProjetCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets typeProjet history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets typeProjet paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody TypeProjetHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports typeProjet history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody TypeProjetHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets typeProjet history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody TypeProjetHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public TypeProjetRestAdmin (TypeProjetAdminService service, TypeProjetConverter converter) {
        super(service, converter);
    }


}