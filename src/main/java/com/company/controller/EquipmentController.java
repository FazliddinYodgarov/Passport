package com.company.controller;

import com.company.dto.*;
import com.company.dto.equipments.*;
import com.company.exp.ItemNotFoundException;
import com.company.service.PaginationService;
import com.company.service.equipment.*;
import com.company.service.FactoryService;
import com.company.type.EquipmentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/equipment")
public class EquipmentController {

    @Autowired
    private ExchangerService exchangerService;
    @Autowired
    private SeparatorService separatorService;
    @Autowired
    private AirCompressorService airCompressorService;
    @Autowired
    private AVOService avoService;
    @Autowired
    private BoilerService boilerService;
    @Autowired
    private ColumnsService columnsService;
    @Autowired
    private GPAService gpaService;
    @Autowired
    private CompressorService compressorService;
    @Autowired
    private PipelineService pipelineService;
    @Autowired
    private PumpService pumpService;
    @Autowired
    private ReservoirService reservoirService;
    @Autowired
    private TorchService torchService;
    @Autowired
    private FactoryService factoryService;
    @Autowired
    private EquipmentGeneralService equipmentGeneralService;
    @Autowired
    private PaginationService paginationService;


    @RequestMapping("/")
    public String goToHome(@RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
                           @RequestParam(value = "size", required = false, defaultValue = "5") int size,Model model) {
        List<EquipmentBaseDTO> equipmentList = equipmentGeneralService.getEquipmentGeneralInfo();
        model.addAttribute("posts", paginationService.getPage(pageNumber, size));
        model.addAttribute("equipmentList", equipmentList);
        model.addAttribute("factoryList", factoryService.getAll());
        model.addAttribute("equipmentTypeList", EquipmentType.values());
        model.addAttribute("filterDTO", new EquipmentFilterDTO());

        return "equipment";
    }

    @RequestMapping("/go-add")
    public String goAdd(Model model) {
        model.addAttribute("exchanger", new ExchangerDTO());
        model.addAttribute("separator", new SeparatorDTO());
        model.addAttribute("aircompressor", new AirCompressorDTO());
        model.addAttribute("avo", new AVODTO());
        model.addAttribute("boiler", new BoilerDTO());
        model.addAttribute("columns", new ColumnsDTO());
        model.addAttribute("compressor", new CompressorDTO());
        model.addAttribute("gpa", new GPADTO());
        model.addAttribute("pipeline", new PipelineDTO());
        model.addAttribute("pump", new PumpDTO());
        model.addAttribute("reservoir", new ReservoirDTO());
        model.addAttribute("torch", new TorchDTO());
        model.addAttribute("factoryList", factoryService.getAll());
        return "equipmentsAdd";
    }


    @RequestMapping("/search")
    public String searchEquipment(@ModelAttribute EquipmentFilterDTO dto, Model model) {
        List<EquipmentBaseDTO> equipmentList = equipmentGeneralService.filter(dto);
        model.addAttribute("equipmentList", equipmentList);
        model.addAttribute("factoryList", factoryService.getAll());
        model.addAttribute("equipmentTypeList", EquipmentType.values());
        model.addAttribute("filterDTO",dto);
        return "equipment";
    }

    @GetMapping("/go-list/{id}/{type}")
    public String goToAddEquipmentList(@PathVariable("id") Long id, @PathVariable("type") EquipmentType type, Model model) {
        if (type.equals(EquipmentType.EXCHANGER)) {
            List<ExchangerDTO> DTOList = exchangerService.list();
            ExchangerDTO dto = exchangerService.get(id);
            if (Optional.ofNullable(dto).isEmpty()) return "errors/notFound";
            model.addAttribute("exchanger", dto);
            model.addAttribute("exchangerList", DTOList);

            return "equipments/list/exchangerList";
        }
        if (type.equals(EquipmentType.SEPARATOR)) {
            List<SeparatorDTO> DTOList = separatorService.getAll();
            SeparatorDTO dto = separatorService.get(id);
            if (Optional.ofNullable(dto).isEmpty()) return "errors/notFound";
            model.addAttribute("separator", dto);
            model.addAttribute("separatorList", DTOList);
            return "equipments/list/separatorList";
        }
        if (type.equals(EquipmentType.AIR_COMPRESSOR)) {
            List<AirCompressorDTO> DTOList = airCompressorService.getAll();
            AirCompressorDTO dto = airCompressorService.get(id);
            if (Optional.ofNullable(dto).isEmpty()) return "errors/notFound";
            model.addAttribute("aircompressor", dto);
            model.addAttribute("aircompressorList", DTOList);
            return "equipments/list/air_compressorList";
        }
        if (type.equals(EquipmentType.AVO)) {
            List<AVODTO> profileDTOList = avoService.getAll();
            AVODTO dto = avoService.get(id);
            if (Optional.ofNullable(dto).isEmpty()) return "errors/notFound";
            model.addAttribute("avo", dto);
            model.addAttribute("avoList", profileDTOList);
            return "equipments/list/AVOList";
        }
        if (type.equals(EquipmentType.BOILER)) {
            List<BoilerDTO> profileDTOList = boilerService.getAll();
            BoilerDTO dto = boilerService.get(id);
            if (Optional.ofNullable(dto).isEmpty()) return "errors/notFound";
            model.addAttribute("boiler", dto);
            model.addAttribute("boilerList", profileDTOList);
            return "equipments/list/boilerList";
        }
        if (type.equals(EquipmentType.COLUMN)) {
            ColumnsDTO dto = columnsService.get(id);
            if (Optional.ofNullable(dto).isEmpty()) return "errors/notFound";
            model.addAttribute("columns", dto);
            return "equipments/list/columnsList";
        }
        if (type.equals(EquipmentType.COMPRESSOR)) {
            CompressorDTO dto = compressorService.get(id);
            if (Optional.ofNullable(dto).isEmpty()) return "errors/notFound";
            model.addAttribute("compressor", dto);
            return "equipments/list/compressorList";
        }
        if (type.equals(EquipmentType.GPA)) {
            GPADTO dto = gpaService.get(id);
            if (Optional.ofNullable(dto).isEmpty()) return "errors/notFound";
            model.addAttribute("gpa", dto);
            return "equipments/list/AVOList";
        }
        if (type.equals(EquipmentType.PIPELINE)) {
            PipelineDTO dto = pipelineService.get(id);
            if (Optional.ofNullable(dto).isEmpty()) return "errors/notFound";
            model.addAttribute("pipeline", dto);
            return "equipments/list/pipelineList";
        }
        if (type.equals(EquipmentType.PUMP)) {
            PumpDTO dto = pumpService.get(id);
            if (Optional.ofNullable(dto).isEmpty()) return "errors/notFound";
            model.addAttribute("pump", dto);
            return "equipments/list/pumpList";
        }
        if (type.equals(EquipmentType.RESERVOIR)) {
            ReservoirDTO dto = reservoirService.get(id);
            if (Optional.ofNullable(dto).isEmpty()) return "errors/notFound";
            model.addAttribute("reservoir", dto);
            return "equipments/list/reservoirList";
        }
        if (type.equals(EquipmentType.TORCH)) {
            TorchDTO dto = torchService.get(id);
            if (Optional.ofNullable(dto).isEmpty()) return "errors/notFound";
            model.addAttribute("torch", dto);
            return "equipments/list/torchList";
        }
        throw new ItemNotFoundException("Item not found id::" + id);
    }


    // ============================EXCHANGER================================ //


    @PostMapping("/create-teploobmennik")
    public String createExchanger(@ModelAttribute ExchangerDTO dto) {
        exchangerService.create(dto);
        return "redirect:/equipment/";
    }

    @GetMapping("/add-teploobmennik")
    public String goToAddEquipmentPage(Model model) {

        model.addAttribute("exchanger", new ExchangerDTO());
        model.addAttribute("factoryList", factoryService.getAll());
        return "equipment";
    }

    @GetMapping("/go-to-update/exchanger/{id}/")
    public String goToUpdate(@PathVariable("id") Long id, Model model) {
        ExchangerDTO dto = exchangerService.get(id);
        if (Optional.ofNullable(dto).isEmpty()) return "errors/notFound";
        model.addAttribute("exchanger", dto);
        model.addAttribute("factoryList", factoryService.getAll());

        return "equipments/exchanger";
    }

    @RequestMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, @ModelAttribute ExchangerDTO dto) {

        ActionDTO update = exchangerService.update(id, dto);

        if (update.getIsError()) {
            return update.getError();
        }

        return "redirect:/equipment/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        ActionDTO delete = exchangerService.delete(id);
        if (delete.getIsError()) {
            return delete.getError();
        }
        return "redirect:/equipment/";
    }

    // =============================SEPARATOR===================================== //

    @PostMapping("/create/separator")
    public String createABO(SeparatorDTO dto) {
        separatorService.create(dto);
        return "redirect:/equipment/";
    }

    @GetMapping("/add/separator")
    public String goToAddSeparatorPage(Model model) {

        model.addAttribute("separator", new SeparatorDTO());
        model.addAttribute("factoryList", factoryService.getAll());
        return "equipment";
    }

    @GetMapping("/go-to-update/separator/{id}/")
    public String goToUpdateSeparator(@PathVariable("id") Long id, Model model) {
        SeparatorDTO dto = separatorService.get(id);
        if (Optional.ofNullable(dto).isEmpty()) return "errors/notFound";
        model.addAttribute("separator", dto);
        model.addAttribute("factoryList", factoryService.getAll());

        return "equipments/separator";
    }

    @RequestMapping("/update/separator/{id}")
    public String updateSeparator(@PathVariable("id") Long id, @ModelAttribute SeparatorDTO dto) {

        ActionDTO update = separatorService.update(id, dto);

        if (update.getIsError()) {
            return update.getError();
        }

        return "redirect:/equipment/";
    }

    @GetMapping("/delete/separator/{id}")
    public String deleteSeparator(@PathVariable("id") Long id) {
        ActionDTO delete = separatorService.delete(id);
        if (delete.getIsError()) {
            return delete.getError();
        }
        return "redirect:/equipment/";
    }

    // =============================AIR_COMPRESSOR===================================== //

    @PostMapping("/create/aircompressor")
    public String createAirCompressor(AirCompressorDTO dto) {
        airCompressorService.create(dto);
        return "redirect:/equipment/";
    }

    @GetMapping("/add/aircompressor")
    public String goToAddAirCompressorPage(Model model) {

        model.addAttribute("aircompressor", new AirCompressorDTO());
        model.addAttribute("factoryList", factoryService.getAll());
        return "equipment";
    }

    @GetMapping("/go-to-update/aircompressor/{id}/")
    public String goToUpdateAirCompressor(@PathVariable("id") Long id, Model model) {
        AirCompressorDTO dto = airCompressorService.get(id);
        if (Optional.ofNullable(dto).isEmpty()) return "errors/notFound";
        model.addAttribute("aircompressor", dto);
        model.addAttribute("factoryList", factoryService.getAll());

        return "equipments/air_compressor";
    }

    @RequestMapping("/update/aircompressor/{id}")
    public String updateAirCompressor(@PathVariable("id") Long id, @ModelAttribute AirCompressorDTO dto) {

        ActionDTO update = airCompressorService.update(id, dto);

        if (update.getIsError()) {
            return update.getError();
        }

        return "redirect:/equipment/";
    }

    @GetMapping("/delete/aircompressor/{id}")
    public String deleteAirCompressor(@PathVariable("id") Long id) {
        ActionDTO delete = airCompressorService.delete(id);
        if (delete.getIsError()) {
            return delete.getError();
        }
        return "redirect:/equipment/";
    }

    // =============================AVO===================================== //

    @PostMapping("/create/avo")
    public String createAVO(AVODTO dto) {
        avoService.create(dto);
        return "redirect:/equipment/";
    }

    @GetMapping("/add/avo")
    public String goToAddAVOPage(Model model) {

        model.addAttribute("avo", new AirCompressorDTO());
        model.addAttribute("factoryList", factoryService.getAll());
        return "equipment";
    }

    @GetMapping("/go-to-update/avo/{id}/")
    public String goToUpdateAVO(@PathVariable("id") Long id, Model model) {
        AVODTO dto = avoService.get(id);
        if (Optional.ofNullable(dto).isEmpty()) return "errors/notFound";
        model.addAttribute("avo", dto);
        model.addAttribute("factoryList", factoryService.getAll());

        return "equipments/AVO";
    }

    @RequestMapping("/update/avo/{id}")
    public String updateAVO(@PathVariable("id") Long id, @ModelAttribute AVODTO dto) {

        ActionDTO update = avoService.update(id, dto);

        if (update.getIsError()) {
            return update.getError();
        }

        return "redirect:/equipment/";
    }

    @GetMapping("/delete/avo/{id}")
    public String deleteAVO(@PathVariable("id") Long id) {
        ActionDTO delete = avoService.delete(id);
        if (delete.getIsError()) {
            return delete.getError();
        }
        return "redirect:/equipment/";
    }
    // =============================BOILER===================================== //

    @PostMapping("/create/boiler")
    public String createBoiler(BoilerDTO dto) {
        boilerService.create(dto);
        return "redirect:/equipment/";
    }

    @GetMapping("/add/boiler")
    public String goToAddBoilerrPage(Model model) {

        model.addAttribute("boiler", new BoilerDTO());
        model.addAttribute("factoryList", factoryService.getAll());
        return "equipment";
    }

    @GetMapping("/go-to-update/boiler/{id}/")
    public String goToUpdateBoiler(@PathVariable("id") Long id, Model model) {
        BoilerDTO dto = boilerService.get(id);
        if (Optional.ofNullable(dto).isEmpty()) return "errors/notFound";
        model.addAttribute("boiler", dto);
        model.addAttribute("factoryList", factoryService.getAll());

        return "equipments/boiler";
    }

    @RequestMapping("/update/boiler/{id}")
    public String updateBoiler(@PathVariable("id") Long id, @ModelAttribute BoilerDTO dto) {

        ActionDTO update = boilerService.update(id, dto);

        if (update.getIsError()) {
            return update.getError();
        }

        return "redirect:/equipment/";
    }

    @GetMapping("/delete/boiler/{id}")
    public String deleteBoiler(@PathVariable("id") Long id) {
        ActionDTO delete = boilerService.delete(id);
        if (delete.getIsError()) {
            return delete.getError();
        }
        return "redirect:/equipment/";
    }
    // =============================COLUMNS===================================== //

    @PostMapping("/create/columns")
    public String createColumns(ColumnsDTO dto) {
        columnsService.create(dto);
        return "redirect:/equipment/";
    }

    @GetMapping("/add/columns")
    public String goToAddColumnsPage(Model model) {

        model.addAttribute("columns", new ColumnsDTO());
        model.addAttribute("factoryList", factoryService.getAll());
        return "equipment";
    }

    @GetMapping("/go-to-update/columns/{id}/")
    public String goToUpdateColumns(@PathVariable("id") Long id, Model model) {
        ColumnsDTO dto = columnsService.get(id);
        if (Optional.ofNullable(dto).isEmpty()) return "errors/notFound";
        model.addAttribute("columns", dto);
        model.addAttribute("factoryList", factoryService.getAll());

        return "equipments/columns";
    }

    @RequestMapping("/update/columns/{id}")
    public String updateColumns(@PathVariable("id") Long id, @ModelAttribute ColumnsDTO dto) {

        ActionDTO update = columnsService.update(id, dto);

        if (update.getIsError()) {
            return update.getError();
        }

        return "redirect:/equipment/";
    }

    @GetMapping("/delete/columns/{id}")
    public String deleteColumns(@PathVariable("id") Long id) {
        ActionDTO delete = columnsService.delete(id);
        if (delete.getIsError()) {
            return delete.getError();
        }
        return "redirect:/equipment/";
    }
    // =============================COMPRESSOR===================================== //

    @PostMapping("/create/compressor")
    public String createCompressor(CompressorDTO dto) {
        compressorService.create(dto);
        return "redirect:/equipment/";
    }

    @GetMapping("/add/compressor")
    public String goToAddCompressorPage(Model model) {

        model.addAttribute("compressor", new CompressorDTO());
        model.addAttribute("factoryList", factoryService.getAll());
        return "equipment";
    }

    @GetMapping("/go-to-update/compressor/{id}/")
    public String goToUpdateCompressor(@PathVariable("id") Long id, Model model) {
        CompressorDTO dto = compressorService.get(id);
        if (Optional.ofNullable(dto).isEmpty()) return "errors/notFound";
        model.addAttribute("compressor", dto);
        model.addAttribute("factoryList", factoryService.getAll());

        return "equipments/compressor";
    }

    @RequestMapping("/update/compressor/{id}")
    public String updateCompressor(@PathVariable("id") Long id, @ModelAttribute CompressorDTO dto) {

        ActionDTO update = compressorService.update(id, dto);

        if (update.getIsError()) {
            return update.getError();
        }

        return "redirect:/equipment/";
    }

    @GetMapping("/delete/compressor/{id}")
    public String deleteCompressor(@PathVariable("id") Long id) {
        ActionDTO delete = compressorService.delete(id);
        if (delete.getIsError()) {
            return delete.getError();
        }
        return "redirect:/equipment/";
    }
    // =============================GPA===================================== //

    @PostMapping("/create/gpa")
    public String createGPA(GPADTO dto) {
        gpaService.create(dto);
        return "redirect:/equipment/";
    }

    @GetMapping("/add/gpa")
    public String goToAddGPA(Model model) {

        model.addAttribute("gpa", new GPADTO());
        model.addAttribute("factoryList", factoryService.getAll());
        return "equipment";
    }

    @GetMapping("/go-to-update/gpa/{id}/")
    public String goToUpdateGPA(@PathVariable("id") Long id, Model model) {
        GPADTO dto = gpaService.get(id);
        if (Optional.ofNullable(dto).isEmpty()) return "errors/notFound";
        model.addAttribute("gpa", dto);
        model.addAttribute("factoryList", factoryService.getAll());

        return "equipments/GPA";
    }

    @RequestMapping("/update/gpa/{id}")
    public String updateGPA(@PathVariable("id") Long id, @ModelAttribute GPADTO dto) {

        ActionDTO update = gpaService.update(id, dto);

        if (update.getIsError()) {
            return update.getError();
        }

        return "redirect:/equipment/";
    }

    @GetMapping("/delete/gpa/{id}")
    public String deleteGPA(@PathVariable("id") Long id) {
        ActionDTO delete = airCompressorService.delete(id);
        if (delete.getIsError()) {
            return delete.getError();
        }
        return "redirect:/equipment/";
    }
    // =============================PIPELINE===================================== //

    @PostMapping("/create/pipeline")
    public String createPipeline(PipelineDTO dto) {
        pipelineService.create(dto);
        return "redirect:/equipment/";
    }

    @GetMapping("/add/pipeline")
    public String goToAddPipelinePage(Model model) {

        model.addAttribute("pipeline", new PipelineDTO());
        model.addAttribute("factoryList", factoryService.getAll());
        return "equipment";
    }

    @GetMapping("/go-to-update/pipeline/{id}/")
    public String goToUpdatePipeline(@PathVariable("id") Long id, Model model) {
        PipelineDTO dto = pipelineService.get(id);
        if (Optional.ofNullable(dto).isEmpty()) return "errors/notFound";
        model.addAttribute("pipeline", dto);
        model.addAttribute("factoryList", factoryService.getAll());

        return "equipments/pipeline";
    }

    @RequestMapping("/update/pipeline/{id}")
    public String updatePipeline(@PathVariable("id") Long id, @ModelAttribute PipelineDTO dto) {

        ActionDTO update = pipelineService.update(id, dto);

        if (update.getIsError()) {
            return update.getError();
        }

        return "redirect:/equipment/";
    }

    @GetMapping("/delete/pipeline/{id}")
    public String deletePipeline(@PathVariable("id") Long id) {
        ActionDTO delete = pipelineService.delete(id);
        if (delete.getIsError()) {
            return delete.getError();
        }
        return "redirect:/equipment/";
    }
    // =============================PUMP===================================== //

    @PostMapping("/create/pump")
    public String createPump(PumpDTO dto) {
        pumpService.create(dto);
        return "redirect:/equipment/";
    }

    @GetMapping("/add/pump")
    public String goToPump(Model model) {

        model.addAttribute("pump", new PumpDTO());
        model.addAttribute("factoryList", factoryService.getAll());
        return "equipment";
    }

    @GetMapping("/go-to-update/pump/{id}/")
    public String goToUpdatePump(@PathVariable("id") Long id, Model model) {
        PumpDTO dto = pumpService.get(id);
        if (Optional.ofNullable(dto).isEmpty()) return "errors/notFound";
        model.addAttribute("pump", dto);
        model.addAttribute("factoryList", factoryService.getAll());

        return "equipments/pump";
    }

    @RequestMapping("/update/pump/{id}")
    public String updatePump(@PathVariable("id") Long id, @ModelAttribute PumpDTO dto) {

        ActionDTO update = pumpService.update(id, dto);

        if (update.getIsError()) {
            return update.getError();
        }

        return "redirect:/equipment/";
    }

    @GetMapping("/delete/pump/{id}")
    public String deletePump(@PathVariable("id") Long id) {
        ActionDTO delete = pumpService.delete(id);
        if (delete.getIsError()) {
            return delete.getError();
        }
        return "redirect:/equipment/";
    }

    // =============================RESERVOIR===================================== //

    @PostMapping("/create/reservoir")
    public String createReservoir(ReservoirDTO dto) {

        reservoirService.create(dto);
        return "redirect:/equipment/";
    }

    @GetMapping("/add/reservoir")
    public String goToAddReservoir(Model model) {

        model.addAttribute("reservoir", new ReservoirDTO());
        model.addAttribute("factoryList", factoryService.getAll());
        return "equipment";
    }

    @GetMapping("/go-to-update/reservoir/{id}/")
    public String goToUpdateReservoir(@PathVariable("id") Long id, Model model) {
        ReservoirDTO dto = reservoirService.get(id);
        if (Optional.ofNullable(dto).isEmpty()) return "errors/notFound";
        model.addAttribute("reservoir", dto);
        model.addAttribute("factoryList", factoryService.getAll());

        return "equipments/reservoir";
    }

    @RequestMapping("/update/reservoir/{id}")
    public String updateReservoir(@PathVariable("id") Long id, @ModelAttribute ReservoirDTO dto) {

        ActionDTO update = reservoirService.update(id, dto);

        if (update.getIsError()) {
            return update.getError();
        }

        return "redirect:/equipment/";
    }

    @GetMapping("/delete/reservoir/{id}")
    public String deleteReservoir(@PathVariable("id") Long id) {
        ActionDTO delete = reservoirService.delete(id);
        if (delete.getIsError()) {
            return delete.getError();
        }
        return "redirect:/equipment/";
    }
    // =============================TORCH===================================== //

    @PostMapping("/create/torch")
    public String createTorch(TorchDTO dto) {
        torchService.create(dto);
        return "redirect:/equipment/";
    }

    @GetMapping("/add/torch")
    public String goToAddTorchPage(Model model) {

        model.addAttribute("torch", new TorchDTO());
        model.addAttribute("factoryList", factoryService.getAll());
        return "equipment";
    }

    @GetMapping("/go-to-update/torch/{id}/")
    public String goToUpdateTorch(@PathVariable("id") Long id, Model model) {
        TorchDTO dto = torchService.get(id);
        if (Optional.ofNullable(dto).isEmpty()) return "errors/notFound";
        model.addAttribute("torch", dto);
        model.addAttribute("factoryList", factoryService.getAll());

        return "equipments/torch";
    }

    @RequestMapping("/update/torch/{id}")
    public String updateTorch(@PathVariable("id") Long id, @ModelAttribute TorchDTO dto) {

        ActionDTO update = torchService.update(id, dto);

        if (update.getIsError()) {
            return update.getError();
        }

        return "redirect:/equipment/";
    }

    @GetMapping("/delete/torch/{id}")
    public String deleteTorch(@PathVariable("id") Long id) {
        ActionDTO delete = torchService.delete(id);
        if (delete.getIsError()) {
            return delete.getError();
        }
        return "redirect:/equipment/";
    }
}
