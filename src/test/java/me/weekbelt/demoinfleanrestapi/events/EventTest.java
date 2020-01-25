package me.weekbelt.demoinfleanrestapi.events;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.assertj.core.api.Assertions.assertThat;

//@RunWith(JUnitParamsRunner.class)
public class EventTest {
    
    @Test
    public void builder() throws Exception {
        //given
        Event event = Event.builder()
                .name("Inflearn Spring REST API")
                .description("REST API develoment with Spring")
                .build();
        //then
        assertThat(event).isNotNull();
    }

    @Test
    public void javaBean() throws Exception {
        //given
        String name = "Event";
        String spring = "Spring";

        //when
        Event event = new Event();
        event.setName(name);
        event.setDescription(spring);

        //then
        assertThat(event.getName()).isEqualTo(name);
        assertThat(event.getDescription()).isEqualTo(spring);

    }

    @DisplayName("basePrice와 maxPrice에 따른 스터디 무료 여부")
    @ParameterizedTest(name = "{index} {displayName}")
    @CsvSource({
            "0, 0, true",
            "100, 0, false",
            "0, 100, false"
    })
    public void testFree(Integer basePrice, Integer maxPrice, Boolean isFree) {
        // Given
        Event event = Event.builder()
                .basePrice(basePrice)
                .maxPrice(maxPrice)
                .build();

        // When
        event.update();

        // Then
        assertThat(event.isFree()).isEqualTo(isFree);
    }

//    JUnit4에서 파라미터값을 Type Safe하기위한 로직
//    private Object[] parametersForTestFree() {
//        return new Object[] {
//          new Object[] {0, 0, true},
//          new Object[] {100, 0, false},
//          new Object[] {0, 100, false},
//          new Object[] {100, 200, false}
//        };
//    }
    
    @DisplayName("스터디 오프라인 or 온라인 여부")
    @ParameterizedTest(name = "{index} {displayName}")
    @CsvSource({
            "강남역 네이버 D2 스타트업 팩토리, true",
            " , false",
            ", false"
    })
    public void testOffline(String location, boolean isOffline) throws Exception {
        //given
        Event event = Event.builder()
                .location(location)
                .build();

        //when
        event.update();

        //then
        assertThat(event.isOffline()).isEqualTo(isOffline);
    }
}