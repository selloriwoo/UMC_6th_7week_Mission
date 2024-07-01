package umc.PJR.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.PJR.apiPayload.ApiResponse;
import umc.PJR.converter.MissionConverter;
import umc.PJR.converter.RestaurantConverter;
import umc.PJR.converter.ReviewConverter;
import umc.PJR.domain.Mission;
import umc.PJR.domain.Restaurant;
import umc.PJR.domain.Review;
import umc.PJR.service.RestaurantService.RestaurantCommandService;
import umc.PJR.service.RestaurantService.RestaurantQueryService;
import umc.PJR.web.dto.RestaurantRequestDTO;
import umc.PJR.web.dto.RestaurantResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/restaurants")
public class RestaurantRestController {

    private final RestaurantCommandService restaurantCommandService;
    private final RestaurantQueryService restaurantQueryService;

    @PostMapping("/signUp")
    public ApiResponse<RestaurantResponseDTO.JoinResultDTO> join(@RequestBody @Valid RestaurantRequestDTO.JoinDto request) {
        Restaurant restaurant = restaurantCommandService.joinRestaurant(request);
        return ApiResponse.onSuccess(RestaurantConverter.toJoinResultDTO(restaurant));
    }
    @PostMapping("/{restaurantId}/reviews")
    public ApiResponse<RestaurantResponseDTO.PostReviewDTO> post(@RequestBody @Valid RestaurantRequestDTO.PostReviewDTO request,
                                                                 @PathVariable(name = "restaurantId") Long restaurantId,
                                                                 @RequestParam (name = "userId") Long userId)  {
        Review review = restaurantCommandService.postReview(userId, restaurantId, request);
        return ApiResponse.onSuccess(ReviewConverter.toPostResultDTO(review));
    }
    @PostMapping("/{restaurantId}/missions/add")
    public ApiResponse<RestaurantResponseDTO.AddMissionDTO> AddMission(@RequestBody @Valid RestaurantRequestDTO.AddMissionDTO request,
                                                                       @PathVariable(name = "restaurantId") Long restaurantId) {
        Mission mission = restaurantCommandService.addMission(restaurantId, request);
        return ApiResponse.onSuccess(MissionConverter.toAddMissionDTO(mission));
    }

    @GetMapping("/{restaurantId}/reviews")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API",description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "restaurantId", description = "가게의 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "페이지 번호, 0번이 1페이지 입니다.")
    })
    public ApiResponse<RestaurantResponseDTO.ReviewPreViewListDTO> getReviewList(@PathVariable(name = "restaurantId") Long restaurantId,
                                                                                 @RequestParam(name = "page") Integer page){
        Page<Review> reviewPage = restaurantQueryService.getReviewList(restaurantId, page);
        return ApiResponse.onSuccess(ReviewConverter.reviewPreViewListDTO(reviewPage));
    }

    @GetMapping("/reviews/user")
    @Operation(summary = "특정 유저의 리뷰 목록 조회 API",description = "특정 가게의 유저들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "userId", description = "유저의 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "페이지 번호, 0번이 1페이지 입니다.")
    })
    public ApiResponse<RestaurantResponseDTO.ReviewPreViewListDTO> getUserReview(@RequestParam (name = "userId") Long userId,
                                                                                 @RequestParam(name = "page") Integer page){
        Page<Review> reviewUserPage = restaurantQueryService.getUserReviewList(userId, page);
        return ApiResponse.onSuccess(ReviewConverter.reviewPreViewListDTO(reviewUserPage));
    }


}
