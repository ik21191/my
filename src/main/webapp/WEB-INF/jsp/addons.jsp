<div class="pop_pro_detail">
<h3>Make it Extra Special with</h3>
<div class="pop_pro_detail_tab">
<div class="pop_pro_detail_tab_inn">
<h4>Frequently Bought Together (Banner)</h4>
<div class="pop_pro_detail_tab_row">
<c:forEach items="${addonListDetails}" var="ad"> 
    <div class="pop_pro_detail_tab_colum">
     <div class="pop_pro_detail_tab_colum_left"><img src="${ad.addonSmallImage}" alt="${ad.addonName}" /></div>
     <div class="pop_pro_detail_tab_colum_right">
     <h5>${ad.addonName}</h5>
     <p><img src="images/pop_up_rupee.png" alt="ruppe" /> ${ad.addonPrice}</p>
    <span><input name="addons1" type="checkbox" value='${ad.addonId}'  class="check_add"/> Add +</span>
     </div>          
     </div>
</c:forEach>
      </div>
</div>
</div>