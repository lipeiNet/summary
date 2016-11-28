package spittr.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import spittr.Spittle;
import spittr.data.SpittleRepository;
import spittr.exceptions.SpittleNotFoundException;

import java.net.URI;
import java.util.List;

/**
 * Created by Administrator on 2016/11/17.
 */
@RestController
@RequestMapping(value = "/spittles")
public class SpittleApiController {
    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleApiController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping(method= RequestMethod.GET, produces="application/json")
    public List<Spittle> spittles(
            @RequestParam(value="max") long max,
            @RequestParam(value="count", defaultValue="20") int count) {
        return spittleRepository.findSpittles(max, count);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET, produces="application/json")
    public Spittle spittleById(@PathVariable Long id) {
        return spittleRepository.findOne(id);
    }

    /**
     * 通过RequestEntity设置头信息（201不仅表示ok还表示创建了新资源）
     * @param spittle
     * @param ucb
     * @return
     */
    @RequestMapping(method=RequestMethod.POST, consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Spittle> saveSpittle(@RequestBody Spittle spittle, UriComponentsBuilder ucb) {
        Spittle saved = spittleRepository.save
                (spittle);

        if (spittle==null){
            throw new SpittleNotFoundException();
        }
        HttpHeaders headers = new HttpHeaders();
        URI locationUri = ucb.path("/spittles/")
                .path(String.valueOf(saved.getId()))
                .build()
                .toUri();
        headers.setLocation(locationUri);

        ResponseEntity<Spittle> responseEntity = new ResponseEntity<Spittle>(saved, headers, HttpStatus.CREATED);
        return responseEntity;
    }

    /**
     * 任何地方抛出的SpittleNotFoundException异常都会在这个方法进行捕获
     * @param e
     * @return
     */
    @ExceptionHandler(SpittleNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody Error spittleNotFound(SpittleNotFoundException e) {
        //long spittleId = e.getSpittleId();
        return new Error(4,"3");
    }
}
