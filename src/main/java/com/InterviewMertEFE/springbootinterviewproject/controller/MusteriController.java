package com.InterviewMertEFE.springbootinterviewproject.controller;

import com.InterviewMertEFE.springbootinterviewproject.model.Musteri;
import com.InterviewMertEFE.springbootinterviewproject.service.MusteriService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MusteriController {

    @Autowired
    private MusteriService musteriService;

    // Müşterileri göster
    @GetMapping("/")
    public String Musteriler(Model model){
        model.addAttribute("MusteriListele",musteriService.getAllMusteri());
        return "index";
    }
    // Müşterileri göster
    @GetMapping("/listele")
    public String musteriListele(Model model){
        model.addAttribute("MusteriListele",musteriService.getAllMusteri());
        return "listele";
    }

    @GetMapping("/kredi")
    public String Kredi(Model model){
        model.addAttribute("kredi",musteriService.getAllMusteri());
        return "kredi";
    }
    @GetMapping("/yeniMusteriEkle")
    public String yeniMusteriEkle(Model model){
        Musteri musteri = new Musteri();
        model.addAttribute("musteri",musteri);
        return "yeniMusteri";
    }
    @PostMapping("/saveMusteri")
    public String musteriKaydet(@ModelAttribute("Musteri") Musteri musteri) {
        // musteriyi veritabanına kayıt et.
        musteriService.saveMusteri(musteri);
        return "redirect:/listele";
    }

    @GetMapping("/yeniGuncellemeFormu/{TC}")
    public String guncellemeFormu(@PathVariable(value = "TC") long TC, Model model) {

        // servisten müsteriyi elde et
        Musteri musteri = musteriService.getMusteriById(TC);

        // musteriyi model attribute olarak ayarla.
        model.addAttribute("musteri", musteri);
        return "update";
    }

    @GetMapping("/deleteMusteri/{TC}")
    public String deleteMusteri(@PathVariable (value = "TC") long TC) {
        // musteriyi sil
        this.musteriService.deleteMusteriById(TC);
        return "redirect:/listele";
    }

    @GetMapping("/onayMusteri/{TC}")
    public String onayMusteri(@PathVariable(value = "TC") long TC,@ModelAttribute("Musteri") Musteri musteri) {
        // müşteriyi veritababına kayıt et
        musteri = musteriService.getMusteriById(TC);
        return "redirect:/listele";
    }

    @GetMapping("/kredial/{TC}")
    public String save(@PathVariable(value = "TC") long TC, Model model) {
        try {
            int onbin = 10000;
            Musteri musteri = musteriService.getMusteriById(TC);
            int krediskor = musteri.getKrediskor();
            int aylikgelir = musteri.getAylikgelir();
            int kredilimit = musteri.getKredilimit();
            int krediLimitCarpani = 4;
            model.addAttribute(musteri);
            if (krediskor < 500)
            {
                return "red";
            }
            else if ((krediskor > 500 && krediskor < 1000) && aylikgelir < 5000)
            {
                musteri.setKredilimit(kredilimit+onbin);
                return "onay";
            }
            else if (krediskor >= 1000)
            {
                musteri.setKredilimit(krediLimitCarpani*aylikgelir);
                return "onay";
            }
            else if((krediskor > 500 && krediskor < 1000) && aylikgelir > 5000)
            {
                return "onay2";
            }
            return "onay";
        }
        catch(Exception e) {
            return "nouser";
        }
    }

    @RequestMapping("/onay")
    public String onayTest(@RequestParam long TC, Model model) {
        try {
            int onbin = 10000;
            Musteri musteri = musteriService.getMusteriById(TC);
            int krediskor = musteri.getKrediskor();
            int aylikgelir = musteri.getAylikgelir();
            int kredilimit = musteri.getKredilimit();
            int krediLimitCarpani = 4;
            model.addAttribute(musteri);
            if (krediskor < 500)
            {
                return "red";
            }
            else if ((krediskor > 500 && krediskor < 1000) && aylikgelir < 5000)
            {
                musteri.setKredilimit(kredilimit+onbin);
                return "onay";
            }
            else if (krediskor >= 1000)
            {
                musteri.setKredilimit(krediLimitCarpani*aylikgelir);
                return "onay";
            }
            else if((krediskor > 500 && krediskor < 1000) && aylikgelir > 5000)
            {
                return "onay2";
            }
            return "onay";
        }
        catch(Exception e) {
            return "nouser";
        }
    }
}
