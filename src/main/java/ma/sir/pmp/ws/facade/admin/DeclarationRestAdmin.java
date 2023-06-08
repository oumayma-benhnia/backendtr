package  ma.sir.pmp.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.pmp.bean.core.Declaration;
import ma.sir.pmp.bean.history.DeclarationHistory;
import ma.sir.pmp.dao.criteria.core.DeclarationCriteria;
import ma.sir.pmp.dao.criteria.history.DeclarationHistoryCriteria;
import ma.sir.pmp.service.facade.admin.DeclarationAdminService;
import ma.sir.pmp.ws.converter.DeclarationConverter;
import ma.sir.pmp.ws.dto.DeclarationDto;
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

@Api("Manages declaration services")
@RestController
@RequestMapping("/api/admin/declaration/")
public class DeclarationRestAdmin  extends AbstractController<Declaration, DeclarationDto, DeclarationHistory, DeclarationCriteria, DeclarationHistoryCriteria, DeclarationAdminService, DeclarationConverter> {


    @ApiOperation("upload one declaration")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @ApiOperation("upload multiple declarations")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all declarations")
    @GetMapping("")
    public ResponseEntity<List<DeclarationDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all declarations")
    @GetMapping("optimized")
    public ResponseEntity<List<DeclarationDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a declaration by id")
    @GetMapping("id/{id}")
    public ResponseEntity<DeclarationDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  declaration")
    @PostMapping("")
    public ResponseEntity<DeclarationDto> save(@RequestBody DeclarationDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  declaration")
    @PutMapping("")
    public ResponseEntity<DeclarationDto> update(@RequestBody DeclarationDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of declaration")
    @PostMapping("multiple")
    public ResponseEntity<List<DeclarationDto>> delete(@RequestBody List<DeclarationDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified declaration")
    @DeleteMapping("")
    public ResponseEntity<DeclarationDto> delete(@RequestBody DeclarationDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified declaration")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple declarations by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by typeDeclaration id")
    @GetMapping("typeDeclaration/id/{id}")
    public List<Declaration> findByTypeDeclarationId(@PathVariable Long id){
        return service.findByTypeDeclarationId(id);
    }
    @ApiOperation("delete by typeDeclaration id")
    @DeleteMapping("typeDeclaration/id/{id}")
    public int deleteByTypeDeclarationId(@PathVariable Long id){
        return service.deleteByTypeDeclarationId(id);
    }
    @ApiOperation("Finds declarations by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<DeclarationDto>> findByCriteria(@RequestBody DeclarationCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated declarations by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody DeclarationCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports declarations by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody DeclarationCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets declaration data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody DeclarationCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets declaration history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets declaration paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody DeclarationHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports declaration history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody DeclarationHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets declaration history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody DeclarationHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public DeclarationRestAdmin (DeclarationAdminService service, DeclarationConverter converter) {
        super(service, converter);
    }


}