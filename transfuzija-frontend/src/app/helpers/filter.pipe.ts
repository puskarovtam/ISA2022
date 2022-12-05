import { Pipe, PipeTransform } from '@angular/core';
import { BloodTransfusionCenter } from '../model/blood-transfusion-center';
import { Search } from '../model/search';

@Pipe({
  name: 'filter',
  pure: false,
})
export class FilterPipe implements PipeTransform {
  transform(centers: BloodTransfusionCenter[], search: Search): any {
    //no centers to return
    if (!centers || centers.length === 0) return centers;

    //search is blank, return centers
    if (!search || (!search.name && !search.city && !search.rating))
      return centers;

    return centers.filter((c) => {
      return (
        (!search.name || c.name.toLowerCase().includes(search.name)) &&
        (!search.city || c.city.match(search.city)) &&
        (!search.rating || c.rating === Number(search.rating))
      );
    });
  }
}
