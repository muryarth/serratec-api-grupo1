package org.serratec.trabalho.grupo1.exception;

public interface MensagensValidator {
    public static String NOT_FOUND = "Nenhum item foi encontrado para o valor fornecido.";
    public static String NOT_BLANK = "O campo não pode ser vazio ou nulo.";
    public static String NOT_NULL = "O campo não pode ser vazio ou nulo.";
    public static String INVALID_SIZE = "Tamanho inválido.";
    public static String INVALID_MAX_SIZE = "O valor inserido viola o tamanho máximo estabelecido.";
    public static String INCOMPATIBLE_EQUALS_ID = "IDs com valores iguais e incompátiveis foram fornecidos.";
}