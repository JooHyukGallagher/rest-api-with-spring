package me.weekbelt.demoinfleanrestapi.events;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EventTest {
    
    @Test
    public void builder() throws Exception {
        //given
        Event event = Event.builder()
                .name("Inflearn Spring REST API")
                .description("REST API develoment with Spring")
                .build();
        //when

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
}