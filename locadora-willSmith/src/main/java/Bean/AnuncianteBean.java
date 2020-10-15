package Bean;

public class AnuncianteBean {
    // Variables
    private int idAnunciante;
    private String nome;
    private String telefone;
    private String email;
    private String senha;

    // Constructors
    public AnuncianteBean(){

    }
    
    public AnuncianteBean(int idAnunciante,String nome, String telefone, String email, String senha) {
        this.nome = nome;
        this.idAnunciante = idAnunciante;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getters And Setters
     public int getIdAnunciante() {
         return idAnunciante;
     }
 
     public void setIdAnunciante(int idAnunciante) {
         this.idAnunciante = idAnunciante;
     }
 
     public String getTelefone() {
         return telefone;
     }
 
     public void setTelefone(String telefone) {
         this.telefone = telefone;
     }
 
     public String getEmail() {
         return email;
     }
 
     public void setEmail(String email) {
         this.email = email;
     }
 
     public String getSenha() {
         return senha;
     }
 
     public void setSenha(String senha) {
         this.senha = senha;
     }
}
