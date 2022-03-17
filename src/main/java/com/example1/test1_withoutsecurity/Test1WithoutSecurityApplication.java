package com.example1.test1_withoutsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Test1WithoutSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(Test1WithoutSecurityApplication.class, args);
    }
}

/*
*******************************************************  Bean  ***********************************************************
@Entity
public class Commande {
@Id @GeneretedValue
private Long id;
private String referencec;
private Double total;
private Double totalPaye;
* Getters & setters
* Constructor
* }

 @Entity
public class Paiment {
@Id @GeneretedValue
private Long id;
private String referencec;
private Double totalPaye;
@ManyToOne
private Commande commande;
* Getters & setters
* Constructor
}

*******************************************************  DAO  ***********************************************************
* @Repository
* public interface CommandeDao extends JpaRepository<Commande,Long>
* {
* public Commande findByReference(String ref);
* public Commande findById(Long id);
* }
*
* @Repository
* public interface PaimentDao extends JpaRepository<Paiment,Long>
* {
* public Paiment findByReference(String ref);
* public Paiment findById(Long id);
* }
*
* ******************************************************  Service  ***********************************************************
* @Service
* public class CommandeService {
* @Autowired
* private CommandeDao commandeDao;
*
* public Commande findByReference(String ref) {  return commandeDao.findByReference(ref);  }
* public Commande findById(Long id) {  return commandeDao.findByid(id);  }
* public int save (Commande commande)
* {
* Commande entity = findByReference(commande.getReference());
* if(entity!=null) return -1;
* else
* {
* commandeDao.save(commande);
* return 1;
* }
* }
*
* public void update(Commande commande)
* {
* Commande entity = findByReference(commande.getReference());
* if(entity!=null) commandeDao.save(commande);
* }
* }
*
*
*
*
* @Service
* public class PaimentService {
* @Autowired
* private PaimentDao paimentDao;
* @Autowired
* private CommandeService commandeService;
* public Paiment findByReference(String ref) {  return paimentDao.findByReference(ref);  }
* public Paiment findById(Long id) {  return paimentDao.findByid(id);  }
* public int save(Paiment paiment)
* {
* Paiment entity = findByReference(paiment.getReference());
* Commande commande = commandeService.findByReference(paiment.getCommande().getReference());
* if(entity!=null) return -1;
* else if(commande==null)  return -2;
* else if(paiment.getTotalPaye() > entity.getCommande().getTotal() - entity.getCommande().getTotalPaye()) return -3;
* else {
* paimentDao.save(paiment);
* commande.setTotalPaye(entity.getCommande().gettotalPaye()+paiment.getTotalPaye());
* commandeService.update(commande);
* return 1;
* }
* }
* }
*
*
*
* **** findByReferenceAndCommandeReference(String paim_Ref,String com_Ref)
 */
/*
@Serrvice
public class CommandeService {
@Autowired
private CommandeDao commandeDao;
@Autowired
private PaimentDao paimentDao;



private int validatePaiment(Commande commande)
{
int cpt=0;
for(Paiment p:commande.getPaiment()) {  if(paimentSerice.findByReferenceAndCommandeReference(p.getReference(),commande.getRefrence())!=null) cpt++; }    }
} return cpt;
}

private void prepared(commande commande)
{
for(Paiment p:commande.getPaiment()) { c.setTotalPaye(c.getTotalPaye()+p.getMontant()); }
}

private void save(Commande commande,List<Paiment> paiments)
{
commandeDao.save(commande);
for(Paiment p:commande.getPaiment()) {  p.setCommande(commande);  paimentService.save(p); }
}


}


@Serrvice
public class PaimentService {
@Autowired
private CommandeService commandeService;

@Autowired
private PaimentDao paimentDao;



public void save (Paiment paiment) {    paimentDao.save(paiment); }




public int save2(List<Paiment> paiments)
{
Double i=0d;


for(Paiment p:paiments)
{
i += p.getMontant();
}
if(i>paiment.getCommande().getTotalPaye()) return -1;
else
{
commandeService.save(paimant.getCommande(),paiments);
return 1;
}
}
}




















 */
