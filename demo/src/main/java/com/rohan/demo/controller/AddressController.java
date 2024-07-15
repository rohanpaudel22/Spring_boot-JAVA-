package com.rohan.demo.controller;

import com.rohan.demo.dto.request.AddressCreationDTO;
import com.rohan.demo.dto.response.AddressResponseDTO;
import com.rohan.demo.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addr")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;
    private final ServerProperties serverProperties;

    @PostMapping("/save")
    public ResponseEntity<AddressResponseDTO> save(@RequestBody
                                                   AddressCreationDTO request) {
        return ResponseEntity.ok(addressService.save(request));
    }
    @GetMapping("/fetch")
    public ResponseEntity<List<AddressResponseDTO>> fetch() {
        return ResponseEntity.ok(addressService.findAllAddress());
    }

    @GetMapping("/get")
    public ResponseEntity<AddressResponseDTO> getAddress(@RequestParam("id") Integer id) {
        return ResponseEntity.ok(addressService.findAddressById(id));
    }

    @PutMapping("/update")
    public ResponseEntity<AddressResponseDTO> update(@RequestParam Integer id,
                                                     @RequestBody AddressCreationDTO
                                                             request) {
        return ResponseEntity.ok(addressService.updateAddress(id,request));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam("id") Integer id) {
        return ResponseEntity.ok(addressService.deleteAddressById(id));
    }
}
