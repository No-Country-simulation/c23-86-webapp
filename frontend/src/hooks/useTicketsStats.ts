import { useState, useEffect } from "react";

export type Stat = { label: string; count: number };
export type Ticket = { id: number; description: string; date: string };
export type RecentTickets = Record<string, Ticket[]>;

export default function useTicketsStats() {
  const [stats, setStats] = useState<Stat[]>([]);
  const [recentTickets, setRecentTickets] = useState<RecentTickets>({});

  useEffect(() => {
    const mockStats: Stat[] = [
      { label: "USTED", count: 5 },
      { label: "GRUPOS", count: 5 },
      { label: "BUENOS", count: 0 },
      { label: "MALOS", count: 0 },
      { label: "RESUELTOS", count: 0 },
    ];
    setStats(mockStats);

    const mockRecentTickets: RecentTickets = {
      USTED: [
        { id: 1, description: "Ticket 1", date: "2025-01-21" },
        { id: 2, description: "Ticket 2", date: "2025-01-21" },
      ],
      GRUPOS: [
        { id: 3, description: "Ticket 3", date: "2025-01-21" },
        { id: 4, description: "Ticket 4", date: "2025-01-21" },
      ],
    };
    setRecentTickets(mockRecentTickets);
  }, []);

  return { stats, recentTickets };
}
