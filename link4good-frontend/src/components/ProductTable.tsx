export default function ProductTable() {
  return (
    <div className="min-w-96">
      <table className="table table-zebra text-black">
        {/* head */}
        <thead className="text-black">
          <tr>
            <th>Cod.</th>
            <th>Descrição</th>
            <th>Qtd.</th>
            <th>Und.</th>
            <th>Valor</th>
          </tr>
        </thead>
        <tbody>
          {/* row 1 */}
          <tr>
            <th>001</th>
            <td>Fraldas</td>
            <td>500</td>
            <td>UN</td>
            <td>R$ 2000,00</td>
          </tr>
          {/* row 2 */}
          <tr>
            <th>002</th>
            <td>Shampoo</td>
            <td>500</td>
            <td>UN</td>
            <td>R$ 2000,00</td>
          </tr>
          {/* row 3 */}
          <tr>
            <th>003</th>
            <td>Desodorante</td>
            <td>500</td>
            <td>UN</td>
            <td>R$ 2000,00</td>
          </tr>
          {/* row 4 */}
          <tr>
            <th>004</th>
            <td>Amaciante</td>
            <td>500</td>
            <td>UN</td>
            <td>R$ 2000,00</td>
          </tr>
          {/* row 5 */}
          <tr>
            <th>005</th>
            <td>Sabonete</td>
            <td>500</td>
            <td>UN</td>
            <td>R$ 2000,00</td>
          </tr>
          {/* row 6 */}
          <tr>
            <th>006</th>
            <td>Condimento</td>
            <td>500</td>
            <td>UN</td>
            <td>R$ 2000,00</td>
          </tr>
        </tbody>
      </table>
    </div>
  )
}
