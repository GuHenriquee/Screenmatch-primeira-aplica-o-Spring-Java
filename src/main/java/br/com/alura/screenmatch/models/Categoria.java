package br.com.alura.screenmatch.models;

public enum Categoria {
    ACAO("Action"),
    ROMANCE("Romance"),
    COMEDIA("Comedy"),
    DRAMA("Romance"),
    CRIME("Crime");
    private String categoriaOmdb;

    Categoria(String categotiaOmdb) {
        this.categoriaOmdb = categotiaOmdb;
    }
    public static Categoria fromString(String text) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.categoriaOmdb.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
    }
}
