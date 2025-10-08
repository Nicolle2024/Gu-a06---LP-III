package ejer2;

public class Usuario {
    private String username;
    private String password;
    private String email;
    private boolean autenticado;

    public Usuario(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.autenticado = false;
    }

    // Getters y Setters
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getEmail() { return email; }
    public boolean isAutenticado() { return autenticado; }
    public void setAutenticado(boolean autenticado) { this.autenticado = autenticado; }

    public boolean verificarPassword(String password) {
        return this.password.equals(password);
    }
}