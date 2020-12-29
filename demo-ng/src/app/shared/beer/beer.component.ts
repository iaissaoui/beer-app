import { Component, Input, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Beer } from '../../beer';
import { BeerService } from '../../beer.service';
import { BehaviorSubject } from 'rxjs';


@Component({
  selector: 'app-beer',
  templateUrl: './beer.component.html',
  styleUrls: ['./beer.component.scss']
})
export class BeerComponent implements OnInit {

  @Input() id!:number
  @Input() random!:boolean;
  private _beer!: Beer;



  constructor(
    private route:ActivatedRoute,
    private router:Router,
    private beerService: BeerService
    ) { }

  ngOnInit(): void {

    if(this.random){

      this.beerService.getRandom().subscribe(data => {
        this.beer = data;
      });
    }else{
      this.beerService.getSingle(this.id).subscribe(data => {
        this.beer = data;
      });
    }


  }

  public get beer(): Beer {
    return this._beer;
  }
  public set beer(value: Beer) {
    this._beer = value;
  }


}
