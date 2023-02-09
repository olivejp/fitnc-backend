package nc.deveo.fitncbackend.controller;

import lombok.RequiredArgsConstructor;
import nc.deveo.fitncbackend.controller.interfaces.WithControllerCreate;
import nc.deveo.fitncbackend.controller.interfaces.WithControllerDelete;
import nc.deveo.fitncbackend.controller.interfaces.WithControllerUpdate;
import nc.deveo.fitncbackend.dto.EntrainementDto;
import nc.deveo.fitncbackend.service.EntrainementService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/entrainement")
public class EntrainementController implements
        WithControllerCreate<EntrainementDto, EntrainementService>,
        WithControllerUpdate<EntrainementDto, EntrainementService>,
        WithControllerDelete<EntrainementService> {

    private final EntrainementService entrainementService;

    @GetMapping
    public Page<EntrainementDto> readAll(@RequestParam(name = "page", required = false, defaultValue = "0") final Integer page,
                                         @RequestParam(name = "size", required = false, defaultValue = "20") final Integer size,
                                         @RequestParam(name = "sort", required = false) Sort sort) {
        if (sort == null) {
            sort = Sort.unsorted();
        }
        final Pageable pageable = PageRequest.of(page, size, sort);
        return getService().readPage(pageable);
    }

    @GetMapping("/{id}")
    public EntrainementDto read(@PathVariable Long id) {
        return getService().read(id);
    }

    @GetMapping("/by-date")
    public List<EntrainementDto> getFromDateTime(@RequestParam(name = "year") final Integer year,
                                                 @RequestParam(name = "month") final Integer month,
                                                 @RequestParam(name = "day") final Integer day) {
        final LocalDate selectedDate = LocalDate.of(year, month, day);
        return entrainementService.getFromDateTime(selectedDate);
    }

    @Override
    public EntrainementService getService() {
        return entrainementService;
    }

}
