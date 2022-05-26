package fr.eni.projet.dal;



import fr.eni.projet.BusinessException;
import fr.eni.projet.bo.Utilisateur;



public interface UtilisateurDAO {

public void insert(Utilisateur u) throws BusinessException;
public void select(Utilisateur u) throws BusinessException;
public void create(Utilisateur u) throws BusinessException;
public void update(Utilisateur u) throws BusinessException;
public void delete (Utilisateur u) throws BusinessException;
boolean Select_all(Utilisateur u);
boolean loginUtilisateur(String noUtilisateur, String motDePasse);
public Utilisateur findByEmail(String email);
public Utilisateur findByPseudo(String pseudo);
public Utilisateur findById(int id);



}