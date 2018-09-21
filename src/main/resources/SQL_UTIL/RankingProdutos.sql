SELECT  distinct PV.idproduto,
PD.descriao,
PV.qtde,
PV.precounit,
PV.qtde*PV.precounit as total_venda,
PV.qtde*PD.preco_custo as custo_total,
(PV.qtde*PV.precounit)/(PV.qtde*PD.preco_custo) as margem
  FROM public.produto_venda PV inner join public.produto PD ON PV.idproduto=PD.idproduto;

