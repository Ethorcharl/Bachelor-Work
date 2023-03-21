package com.bach_work.yachtwebsite.service;
import com.bach_work.yachtwebsite.ships.model.ShipType;
import com.bach_work.yachtwebsite.ships.repository.TypeRepository;
import com.bach_work.yachtwebsite.ships.service.TypeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
public class TypeServiceTest {
    private final TypeRepository typeRepository = Mockito.mock(TypeRepository.class);
    private final TypeService typeService = new TypeService(typeRepository);
    private final int typeId = 333;
    @Test
    public void findByIdTest(){
        when(typeRepository.findById(typeId)).thenReturn(Optional.of(getTestType()));
        ShipType shipType = typeService.findById(typeId);
        assertEquals(22, shipType.getType_id());
    }
    @Test
    public void findByIdFail(){
        when(typeRepository.findById(typeId)).thenReturn(Optional.empty());
        ShipType shipType = typeService.findById(typeId);
        assertNull(shipType);
    }
    @Test
    public void findAllTest(){
        when(typeRepository.findAll()).thenReturn(getTypeList());
        assertEquals(2, typeService.findAll().size());
    }
    @Test
    public void saveTypeTest(){
        ShipType shipTypeSave=getTestType();
        when(typeRepository.save(shipTypeSave)).thenReturn(shipTypeSave);
        ShipType shipType = typeService.saveType(shipTypeSave);
        assertEquals(getTestType().getType_id(), shipType.getType_id());
    }
    @Test
    public void  deleteByIdTest(){
        assertDoesNotThrow(()->typeService.deleteById(typeId));
    }
    private ShipType getTestType() {
        ShipType shipType = new ShipType();
        shipType.setType_id(22);
        shipType.setDescription("Hello");
        return shipType;
    }
    private List<ShipType> getTypeList() {
        List<ShipType> typeList = new ArrayList<>();
        typeList.add(getTestType());
        ShipType shipType = getTestType();
        shipType.setType_id(33);
        typeList.add(shipType);
        return typeList;
    }
}