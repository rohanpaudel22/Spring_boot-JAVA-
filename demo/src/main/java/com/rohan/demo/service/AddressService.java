    package com.rohan.demo.service;

    import com.rohan.demo.dto.request.AddressCreationDTO;
    import com.rohan.demo.dto.response.AddressResponseDTO;
    import com.rohan.demo.entity.AddressEntity;
    import com.rohan.demo.repo.AddressRepo;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import java.util.ArrayList;
    import java.util.List;

    @Service
    public class AddressService {
        @Autowired
        private AddressRepo addressRepo;

        public AddressResponseDTO save(AddressCreationDTO  request){
            AddressEntity addressEntity = new AddressEntity();
            addressEntity.setDistrict(request.getDistrict());
            addressEntity.setStreet(request.getStreet());
            AddressEntity savedAddress = addressRepo.saveAndFlush(addressEntity);
            return new AddressResponseDTO(savedAddress);
        }
        public List<AddressResponseDTO> findAllAddress(){
            List<AddressEntity> allRecords = addressRepo.findAll();
            List<AddressResponseDTO> addressResponseDTOS = new ArrayList<>();
            allRecords.forEach(item->{
                AddressResponseDTO addressResponseDTO = new AddressResponseDTO(item);
                addressResponseDTOS.add(addressResponseDTO);
            });
            return addressResponseDTOS;
        }
        public AddressResponseDTO findAddressById(Integer id){
            AddressEntity addressEntity = addressRepo.findById(id).orElse(null);
            return new AddressResponseDTO(addressEntity);
        }
        public AddressResponseDTO updateAddress(Integer id, AddressCreationDTO  request){
            AddressEntity addressEntity = addressRepo.findById(id).orElse(null);
            if(addressEntity ==null){
                return null;
            }
            addressEntity.setDistrict(request.getDistrict());
            addressEntity.setStreet(request.getStreet());
            AddressEntity savedAddress = addressRepo.saveAndFlush(addressEntity);
            return new AddressResponseDTO(savedAddress);
        }
        public String deleteAddressById(Integer id){
            addressRepo.deleteById(id);
            return "Address is deleted";
        }
    }