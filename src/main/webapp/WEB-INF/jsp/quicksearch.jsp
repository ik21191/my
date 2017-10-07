<form action="quicksearch.htm">
<div class="quick_search">
<div class="quick_search_left"><strong>QUICK SEARCH</strong></div>
<div class="city"><label>City</label>
<select name="" class="inp_city">
<option>Delivery Location</option>
<c:forEach items="${cityList}" var="city">
    <option value="${city.cityId}">${city.cityName}</option>
</c:forEach>
</select>
</div>

<div class="deliery_date"><label>Date</label>
<input type="text" size="12" id="inputField" class="inp_city"/>
</div>

<div class="Occasion"><label>Occasion</label>
<select name="occasion" class="inp_city">
    <option value="1">Birthday</option>
    <option value="5">Anniversary</option>
    <option value="5">New Year</option>
    <option value="5">Congratulations</option>
    <option value="5">Valentine Day</option>
    <option value="5">Lohri</option>
    <option value="5">Diwali</option>
</select>
</div>
<div><input name="" type="button" class="go-sub" value="" /></div>
</div>
</form>