package ma.sir.pmp.dao.criteria.core;

import ma.sir.pmp.bean.core.Client;
import ma.sir.pmp.bean.core.TypeVente;
import ma.sir.pmp.zynerator.criteria.BaseCriteria;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.List;

public class VenteCriteria extends BaseCriteria {
    private String code;
     private String codeLike;

    private String libelle;
    private String libelleLike;
    private TypeVenteCriteria typeVente ;
    private List<TypeVenteCriteria> typeVentes ;
    private LocalDateTime dateVente ;
    private LocalDateTime dateVenteFrom ;
    private LocalDateTime dateVenteTo ;
    private ClientCriteria client;
    private List<ClientCriteria> clients;
    public VenteCriteria(){}

    public List<TypeVenteCriteria> getTypeVentes() {
        return typeVentes;
    }

    public void setTypeVentes(List<TypeVenteCriteria> typeVentes) {
        this.typeVentes = typeVentes;
    }

    public List<ClientCriteria> getClients() {
        return clients;
    }

    public void setClients(List<ClientCriteria> clients) {
        this.clients = clients;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeLike() {
        return codeLike;
    }

    public void setCodeLike(String codeLike) {
        this.codeLike = codeLike;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelleLike() {
        return libelleLike;
    }

    public void setLibelleLike(String libelleLike) {
        this.libelleLike = libelleLike;
    }

    public TypeVenteCriteria getTypeVente() {
        return typeVente;
    }

    public void setTypeVente(TypeVenteCriteria typeVente) {
        this.typeVente = typeVente;
    }

    public LocalDateTime getDateVente() {
        return dateVente;
    }

    public void setDateVente(LocalDateTime dateVente) {
        this.dateVente = dateVente;
    }

    public LocalDateTime getDateVenteFrom() {
        return dateVenteFrom;
    }

    public void setDateVenteFrom(LocalDateTime dateVenteFrom) {
        this.dateVenteFrom = dateVenteFrom;
    }

    public LocalDateTime getDateVenteTo() {
        return dateVenteTo;
    }

    public void setDateVenteTo(LocalDateTime dateVenteTo) {
        this.dateVenteTo = dateVenteTo;
    }

    public ClientCriteria getClient() {
        return client;
    }

    public void setClient(ClientCriteria client) {
        this.client = client;
    }
}
