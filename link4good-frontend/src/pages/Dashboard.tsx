// @ts-nocheck
import SimplePieChart from '../components/SimplePieChart'
import SimpleBarChart from '../components/SimpleBarChart'
import SimpleLineChart from '../components/SimpleLineChart'
import type { PropsWithChildren } from 'react'

const userChartData = {
  pieChart: {
    chartName: 'Pedidos',
    chartData: [
      {
        name: 'Aprovadas',
        value: 1500,
      },
      {
        name: 'Pendentes',
        value: 500,
      },
      {
        name: 'Rejeitadas',
        value: 200,
      },
    ],
  },
  barsChart: {
    chartName: 'Marcas mais solicitadas',
    chartData: [
      {
        Omo: 500,
      },
      {
        Rexona: 1500,
      },
      {
        Dove: 4500,
      },
      {
        Confort: 15000,
      },
      {
        Lux: 3500,
      },
      {
        Knorr: 3500,
      },
    ],
  },
  linesChart: {
    chartName: 'Pedidos 2024',
    chartData: [
      {
        time: 'jan',
        pedidos: 500,
      },
      {
        time: 'fev',
        pedidos: 1500,
      },
      {
        time: 'mar',
        pedidos: 4500,
      },
      {
        time: 'abr',
        pedidos: 15000,
      },
      {
        time: 'mai',
        pedidos: 3500,
      },
      {
        time: 'jun',
        pedidos: 6000,
      },
    ],
  },
}

type CardProps = PropsWithChildren<{
  title: string
  className?: string
}>

const Card = ({ className, title, children }: CardProps) => {
  return (
    <div class={`card bg-base-100 ${className} shadow-xl`}>
      <div class="card-body">
        <h2 class="card-title">{title}</h2>
        {children}
      </div>
    </div>
  )
}

export default function Dashboard() {
  return (
    <section className="w-full h-full justify-start items-start gap-10 flex flex-col p-4 lg:p-8 bg-neutral-200">
      <div className="text-4xl font-semibold flex flex-row gap-4">
        <h1>Dashboard</h1>
        <i className="fa-solid fa-chart-pie" />{' '}
      </div>
      <div class="flex flex-row gap-4 flex-wrap w-full h-full justify-center items-center">
        <Card
          className="h-[500px] w-[500px] max-sm:w-96 max-sm:h-96"
          title={userChartData.pieChart.chartName}
        >
          <SimplePieChart
            className="w-full h-full "
            data={userChartData.pieChart.chartData}
          />
        </Card>
        <Card
          className="h-[500px] w-[500px] max-sm:w-96 max-sm:h-96"
          title={userChartData.barsChart.chartName}
        >
          <SimpleBarChart
            className="w-full h-full"
            data={userChartData.barsChart.chartData}
          />
        </Card>
        <Card
          className="h-[500px] w-[500px] max-sm:w-96 max-sm:h-96"
          title={userChartData.linesChart.chartName}
        >
          <SimpleLineChart
            className="w-full h-full"
            data={userChartData.linesChart.chartData}
          />
        </Card>
      </div>
    </section>
  )
}
