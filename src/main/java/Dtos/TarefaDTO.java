package Dtos;

import jakarta.validation.constraints.NotBlank;

public record TarefaDTO(
        @NotBlank(message = "O título não pode estar em branco.")
        String titulo,

        @NotBlank(message = "A descrição não pode estar em branco.")
        String descricao
)
{

}
