import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Beer } from '../beer';
import { BeerService } from '../beer.service';
import { BehaviorSubject } from 'rxjs';


@Component({
  selector: 'app-beer',
  templateUrl: './beer.component.html',
  styleUrls: ['./beer.component.scss']
})
export class BeerComponent implements OnInit {

  private _beer!: Beer;
  


  constructor(
    private route:ActivatedRoute,
    private router:Router,
    private beerService: BeerService
    ) { }

  ngOnInit(): void {
    let id = this.route.snapshot.params['id'];

    this.beerService.findSingle(id).subscribe(data => {
      console.log(data);
      this.beer = data;
    });
    
  }

  public get beer(): Beer {
    return this._beer;
  }
  public set beer(value: Beer) {
    this._beer = value;
  }


}
