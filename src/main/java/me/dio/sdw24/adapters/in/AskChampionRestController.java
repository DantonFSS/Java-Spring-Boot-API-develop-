package me.dio.sdw24.adapters.in;

import io.swagger.v3.oas.annotations.tags.Tag;
import me.dio.sdw24.application.ListChampionsUseCase;
import me.dio.sdw24.application.AskChampionsUseCase;
import org.springframework.web.bind.annotation.*;

@Tag(name= "Champions", description = "League of Legends champions domain endpoints.")
@RestController
@RequestMapping("/champions")
public record AskChampionRestController(AskChampionsUseCase useCase) {

   @PostMapping("/{championId}/ask")
    public AskChampionResponse askChampion(@PathVariable Long championId, @RequestBody AskChampionRequest request) {

       String answer = useCase.askChampion(championId, request.question());

        return new AskChampionResponse(answer);
    }

    public record AskChampionRequest(String question) { }
    public record AskChampionResponse(String answer) { }
}

