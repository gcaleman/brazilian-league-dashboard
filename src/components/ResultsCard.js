import { React } from 'react';
import { Chart } from "react-google-charts";
import { Card } from 'react-bootstrap';
import './ResultsCard.css';

export const ResultsCard = ({ team }) => {

    if (!team.matches) {
        return <h1>Results not found!</h1>
    }

    var results = {
        wins: [],
        loss: [],
        draws: [],
        homeWins: [],
        homeLoss: [],
        homeDraws: [],
        awayWins: [],
        awayLoss: [],
        awayDraws: []
    };

    const getResults = () => {
        team.matches.map(matches => {
            if (team.teamName === matches.home && matches.res === 'H') {
                results.homeWins.push([matches.res])
                results.wins.push([matches.res])
            }
            if (team.teamName === matches.away && matches.res === 'A') {
                results.awayWins.push([matches.res])
                results.wins.push([matches.res])
            }
            if (team.teamName === matches.away && matches.res === 'H') {
                results.awayLoss.push([matches.res])
                results.loss.push([matches.res])
            }
            if (team.teamName === matches.home && matches.res === 'A') {
                results.homeLoss.push([matches.res])
                results.loss.push([matches.res])
            }
            if (team.teamName === matches.home && matches.res === 'D') {
                results.homeDraws.push(matches.res)
                results.draws.push(matches.res)
            }
            if (team.teamName === matches.away && matches.res === 'D') {
                results.awayDraws.push(matches.res)
                results.draws.push(matches.res)
            }
        })
    }

    getResults();

    return (
        <div className="ResultsCard">
            <Card className="chart_card">
                <Chart
                    width={'350px'}
                    height={'auto'}
                    chartType="PieChart"
                    loader={<div>Loading Chart</div>}
                    data={[
                        ['Results', 'All seasons'],
                        ['Wins', results.wins.length],
                        ['Loss', results.loss.length],
                        ['Draws', results.draws.length],
                    ]}
                    options={{
                        title: 'Results All Seasons',
                        is3D: 'true'
                    }}
                    rootProps={{ 'data-testid': '1' }}
                />
            </Card>
            <Card className="chart_card">
                <Chart
                    width={'350px'}
                    height={'auto'}
                    chartType="PieChart"
                    loader={<div>Loading Chart</div>}
                    data={[
                        ['Results', 'Home Games'],
                        ['Wins', results.homeWins.length],
                        ['Loss', results.homeLoss.length],
                        ['Draws', results.homeDraws.length],
                    ]}
                    options={{
                        title: 'Home Games',
                        is3D: 'true'
                    }}
                    rootProps={{ 'data-testid': '1' }}
                />
            </Card>
            <Card className="chart_card">
                <Chart
                    width={'350px'}
                    height={'auto'}
                    chartType="PieChart"
                    loader={<div>Loading Chart</div>}
                    data={[
                        ['Results', 'Away Games'],
                        ['Wins', results.awayWins.length],
                        ['Loss', results.awayLoss.length],
                        ['Draws', results.awayDraws.length],
                    ]}
                    options={{
                        title: 'Away Games',
                        is3D: 'true'
                    }}
                    rootProps={{ 'data-testid': '1' }}
                />
            </Card>
        </div>
    )

}