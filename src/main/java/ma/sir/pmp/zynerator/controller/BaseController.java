package ma.sir.pmp.zynerator.controller;

import ma.sir.pmp.zynerator.exception.GlobalException;
import ma.sir.pmp.zynerator.export.ExportModel;
import ma.sir.pmp.zynerator.util.BirtWarpper;
import ma.sir.pmp.zynerator.util.ExportUtil;
import ma.sir.pmp.zynerator.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;

public abstract class BaseController {

    @Autowired
    private MessageSource messageSource;


@Value("${uploads.location.directory}")
    private String UPLOADED_FOLDER;

    protected static ClientHttpRequestFactory clientHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setReadTimeout(200000);
        factory.setConnectTimeout(200000);
        return factory;
    }

    private static boolean isNotEmpty(ExportModel exportModel) {
        return exportModel != null && exportModel.getList() != null && !exportModel.getList().isEmpty();
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception e, HttpServletRequest request) throws IOException {
        GlobalException globalException = new GlobalException(e, messageSource, request.getRequestURI());
        ErrorResponse errorResponse = new ErrorResponse(globalException.getStatus(), e, globalException.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(errorResponse, globalException.getStatus());
    }

    // Download file from report tool
    protected ResponseEntity<InputStreamResource> getReportResource(BirtWarpper birtWarpper, String fileName) throws Exception {

        // RestTemplate restTemplate = new
        // RestTemplate(clientHttpRequestFactory());
        // HttpHeaders headers = new HttpHeaders();
        // headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        // final UserDetails userDetails = (UserDetails)
        // SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // Token token = jwtUtil.generateToken(userDetails);
        // headers.set(tokenHeader, "Bearer " + token.getValue());
        // HttpEntity<BirtWarpper> entity = new
        // HttpEntity<BirtWarpper>(birtWarpper, headers);
        // String uri = REPORTING_URL + "/report/generateBytes";
        // ResponseEntity<byte[]> s = restTemplate.postForEntity(uri, entity,
        // byte[].class);
        // InputStream inputStream = new ByteArrayInputStream(s.getBody());
        // InputStreamResource inputStreamResource = new
        // InputStreamResource(inputStream);
        //
        // return
        // ResponseEntity.ok().eTag(fileName).contentLength(s.getBody().length).contentType(MediaType.APPLICATION_PDF).body(inputStreamResource);

        return null;
    }

    // Download file
    protected ResponseEntity<InputStreamResource> getExportedFileResource(ExportModel exportModel) throws Exception {
        if (isNotEmpty(exportModel)) {
            String fichier = ExportUtil.exportedList(exportModel, UPLOADED_FOLDER);
            File file = new File(fichier);
            FileInputStream inputStream = new FileInputStream(file);
            InputStreamResource inputStreamResource = new InputStreamResource(inputStream);
            String fileName = FileUtils.getFileName(file.getName());
            return ResponseEntity.ok().eTag(fileName).contentLength(file.length()).contentType(MediaType.parseMediaType(Files.probeContentType(file.toPath()))).body(inputStreamResource);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    // Download file
    protected ResponseEntity<InputStreamResource> getFileResource(String fichier, String fileName) throws Exception {
        if (fichier != null && !fichier.isEmpty()) {
            File file = new File(UPLOADED_FOLDER + fichier);
            if (file.exists()) {
                FileInputStream inputStream = new FileInputStream(file);
                InputStreamResource inputStreamResource = new InputStreamResource(inputStream);
                return ResponseEntity.ok().eTag(fileName).contentLength(file.length()).contentType(MediaType.parseMediaType(Files.probeContentType(file.toPath()))).body(inputStreamResource);
            }
        }
        return new ResponseEntity<InputStreamResource>(HttpStatus.NOT_FOUND);
    }
}